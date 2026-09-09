package com.alternative_twilight.at_mod.item.spear;

import com.alternative_twilight.at_mod.AlternativeTwilight;
import com.alternative_twilight.at_mod.registry.ModDamageTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * 矛类武器。
 *
 * <p>核心机制（见 docs/需求.md §1）：
 * <ul>
 *   <li>右键突进：以材质初速度向前冲刺，冷却 100 tick；攻击冷却未满时禁止冲刺</li>
 *   <li>速度伤害：突进期间碰撞到的生物按「攻击力 × (速度-1)²」受到
 *       {@code at_mod:spear} 穿刺伤害（最低 1 点），目标获得 10 tick 无敌</li>
 *   <li>被击保护：持有者被攻击后一段时间内矛不结算碰撞伤害
 *       （{@link #PROTECT_UNTIL_KEY}，由事件处理器写入）</li>
 *   <li>攻击命中额外消耗 1 点耐久；手持时使用专属姿态动画（见 SpearClientExtensions）</li>
 * </ul>
 */
public class SpearItem extends TieredItem {

    /** 玩家持矛被打后的保护期截止 gameTime（写入玩家 PersistentData，事件处理器维护） */
    public static final String PROTECT_UNTIL_KEY = "AtmodSpearProtectUntil";

    /** 右键突进的初速度（各材质不同） */
    private final float dashSpeed;

    public SpearItem(Tier tier, Properties properties, float dashSpeed) {
        super(tier, properties.component(DataComponents.TOOL, createToolProperties()));
        this.dashSpeed = dashSpeed;
    }

    /**
     * 构造物品属性修饰符。
     *
     * @param damage 基础攻击力
     * @param speed  攻击速度修正（负值）
     * @param range  交互距离加成（格）
     */
    public static ItemAttributeModifiers createAttributes(double damage, double speed, double range) {
        return ItemAttributeModifiers.builder()
                .add(Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(BASE_ATTACK_DAMAGE_ID, damage, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ATTACK_SPEED,
                        new AttributeModifier(BASE_ATTACK_SPEED_ID, speed, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ENTITY_INTERACTION_RANGE,
                        new AttributeModifier(AlternativeTwilight.prefix("range_modifier"), range, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND)
                .build();
    }

    public static Tool createToolProperties() {
        return new Tool(List.of(Tool.Rule.overrideSpeed(BlockTags.SWORD_EFFICIENT, 1.5F)), 1.0F, 2);
    }

    @Override
    public boolean canAttackBlock(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player) {
        return !player.isCreative();
    }

    @Override
    public boolean onLeftClickEntity(@NotNull ItemStack stack, @NotNull Player player, @NotNull Entity entity) {
        stack.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
        return UseAnim.SPEAR;
    }

    @Override
    public void inventoryTick(@NotNull ItemStack stack, @NotNull Level level, @NotNull Entity entity, int slotId, boolean isSelected) {
        super.inventoryTick(stack, level, entity, slotId, isSelected);

        // 服务端、手持选中且移动速度大于 1 时结算突进碰撞伤害
        if (!level.isClientSide() && isSelected && entity instanceof Player player && player.getDeltaMovement().length() > 1.0) {
            // 攻击冷却中（蓄力未满）不造成伤害
            if (player.getAttackStrengthScale(0.0F) < 1.0F) {
                return;
            }
            // 被击保护期内不造成伤害
            long protectUntil = player.getPersistentData().getLong(PROTECT_UNTIL_KEY);
            if (level.getGameTime() < protectUntil) {
                return;
            }

            AABB boundingBox = player.getBoundingBox().inflate(1.6);
            List<LivingEntity> targets = level.getEntitiesOfClass(LivingEntity.class, boundingBox, e -> e != player && e.isAlive());

            if (!targets.isEmpty()) {
                float totalDamage = (float) player.getAttributeValue(Attributes.ATTACK_DAMAGE);
                var damageRegistry = level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE);
                var damageHolder = damageRegistry.getHolderOrThrow(ModDamageTypes.SPEAR);
                DamageSource spearSource = new DamageSource(damageHolder, player);

                for (LivingEntity target : targets) {
                    if (target.invulnerableTime == 0) {
                        float speed = (float) player.getDeltaMovement().length();
                        target.hurt(spearSource, (float) Math.max(1, totalDamage * Math.pow(speed - 1, 2)));
                        target.invulnerableTime = 10; // 目标 10 tick 无敌时间
                        stack.hurtAndBreak(2, player, EquipmentSlot.MAINHAND);
                    }
                }
            }
        }
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand usedHand) {
        // 攻击冷却中禁止冲刺
        if (player.getAttackStrengthScale(0.0F) < 1.0F) {
            return InteractionResultHolder.fail(player.getItemInHand(usedHand));
        }
        Vec3 dash = player.getForward().scale(this.dashSpeed);
        player.setDeltaMovement(dash);
        player.getCooldowns().addCooldown(this, 100);
        return super.use(level, player, usedHand);
    }
}
