package com.alternative_twilight.at_mod.item.spear;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

/**
 * 矛类专属材质等级。
 *
 * <p>原版材质直接使用 {@link Tiers}；铁木/骑士金属材质使用暮色森林的
 * {@code TFToolMaterials}（见 {@link com.alternative_twilight.at_mod.registry.ModItems}）。
 */
public final class SpearTiers {

    /** 铜：使用石质挖掘等级 */
    public static final SimpleTier COPPER = new SimpleTier(
            BlockTags.INCORRECT_FOR_STONE_TOOL,
            200,   // 耐久
            5.0F,  // 挖掘速度
            1.5F,  // 攻击伤害加成
            14,    // 附魔能力
            () -> Ingredient.of(Items.COPPER_INGOT) // 修复材料
    );

    /** 金矛专属等级（在原版金质基础上耐久 +100） */
    public static final SimpleTier GOLDEN_SPEAR = new SimpleTier(
            Tiers.GOLD.getIncorrectBlocksForDrops(),
            Tiers.GOLD.getUses() + 100, // 32 + 100 = 132
            Tiers.GOLD.getSpeed(),
            Tiers.GOLD.getAttackDamageBonus(),
            Tiers.GOLD.getEnchantmentValue(),
            Tiers.GOLD::getRepairIngredient
    );

    private SpearTiers() {
    }
}
