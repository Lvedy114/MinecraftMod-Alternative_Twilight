package com.alternative_twilight.at_mod.effect;

import com.alternative_twilight.at_mod.AlternativeTwilight;
import com.alternative_twilight.at_mod.config.Config;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

/**
 * 嗜血（增益）。
 *
 * <p>每级提供攻击力与移速的百分比加成（ADD_MULTIPLIED_TOTAL），
 * 数值来自 Config 的 bloodLust 节。巫妖进入第三阶段清场时逐级获得永久实例。
 */
public class BloodLustEffect extends MobEffect {

    public BloodLustEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xB30000);
        addAttributeModifier(Attributes.ATTACK_DAMAGE,
                AlternativeTwilight.prefix("effect.blood_lust.attack"),
                AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL,
                level -> readConfigSafely(Config.BLOOD_LUST_ATTACK_PER_LEVEL::getAsDouble) * (level + 1));
        addAttributeModifier(Attributes.MOVEMENT_SPEED,
                AlternativeTwilight.prefix("effect.blood_lust.speed"),
                AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL,
                level -> readConfigSafely(Config.BLOOD_LUST_SPEED_PER_LEVEL::getAsDouble) * (level + 1));
    }

    /**
     * 注册阶段 NeoForge 会调一次 curve.apply(0) 来填 AttributeTemplate.amount，
     * 此时 ModConfig 尚未加载，直接读 Config 会抛 IllegalStateException。
     * 这个回填值对 curve 模式无实际影响（create(level) 时会重新调 curve），未加载时返回 0 即可。
     */
    private static double readConfigSafely(java.util.function.DoubleSupplier supplier) {
        try {
            return supplier.getAsDouble();
        } catch (IllegalStateException notLoadedYet) {
            return 0.0D;
        }
    }
}
