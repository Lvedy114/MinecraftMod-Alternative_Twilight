package com.alternative_twilight.at_mod.item.spear;

import com.alternative_twilight.at_mod.registry.ModItems;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;
import net.neoforged.neoforge.client.IArmPoseTransformer;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import org.jetbrains.annotations.NotNull;

/**
 * 矛类武器的客户端扩展（仅客户端加载）。
 *
 * <p>通过 EnumExtensions 向 {@code HumanoidModel.ArmPose} 注入 {@code AT_MOD_SPEAR_POSE}
 * （声明见 {@code META-INF/enumextensions.json}），并在客户端扩展注册时为全部矛提供该姿态：
 * 手臂微微抬起并固定。
 */
public final class SpearClientExtensions {

    /** 持矛专属手臂姿态（enumextensions 注入） */
    public static final EnumProxy<HumanoidModel.ArmPose> SPEAR_POSE = new EnumProxy<>(
            HumanoidModel.ArmPose.class, false, (IArmPoseTransformer) (model, entity, arm) -> {
                if (arm == HumanoidArm.RIGHT) {
                    model.rightArm.xRot = -0.5F; // 向前略微抬起
                    model.rightArm.yRot = -0.1F;
                    model.rightArm.zRot = 0.0F;
                } else {
                    model.leftArm.xRot = -0.5F;
                    model.leftArm.yRot = 0.1F;
                    model.leftArm.zRot = 0.0F;
                }
            }
    );

    /** 为全部矛注册持矛姿态（由 client/event 的事件处理器调用） */
    public static void registerSpearPoses(RegisterClientExtensionsEvent event) {
        IClientItemExtensions spearExtension = new IClientItemExtensions() {
            @Override
            public HumanoidModel.ArmPose getArmPose(@NotNull LivingEntity entityLiving, @NotNull InteractionHand hand, @NotNull ItemStack itemStack) {
                return SPEAR_POSE.getValue();
            }
        };

        event.registerItem(spearExtension,
                ModItems.WOODEN_SPEAR.get(),
                ModItems.STONE_SPEAR.get(),
                ModItems.COPPER_SPEAR.get(),
                ModItems.IRON_SPEAR.get(),
                ModItems.GOLDEN_SPEAR.get(),
                ModItems.DIAMOND_SPEAR.get(),
                ModItems.NETHERITE_SPEAR.get(),
                ModItems.IRONWOOD_SPEAR.get(),
                ModItems.KNIGHT_SPEAR.get()
        );
    }

    private SpearClientExtensions() {
    }
}
