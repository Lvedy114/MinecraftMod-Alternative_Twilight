package com.alternative_twilight.at_mod.effect;

import com.alternative_twilight.at_mod.config.Config;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

/**
 * 嗜血诅咒（减益）。
 *
 * <p>由巫妖第一阶段破盾施加并逐级叠加。到期时按等级结算真实伤害
 * （伤害类型 {@code at_mod:blood_curse}，比例见 Config bloodLustCurse 节）。
 */
public class BloodCurseEffect extends MobEffect {

    public BloodCurseEffect() {
        super(MobEffectCategory.HARMFUL, 0x4A0000);
    }

    // TODO: 迁移到期结算逻辑（旧 BloodLustEvents）：
    //  效果到期时对持有者造成「最大生命值 × BLOOD_LUST_CURSE_DAMAGE_PER_LEVEL × (等级+1)」的
    //  at_mod:blood_curse 真实伤害。
}
