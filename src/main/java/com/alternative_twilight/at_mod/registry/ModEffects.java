package com.alternative_twilight.at_mod.registry;

import com.alternative_twilight.at_mod.effect.BloodCurseEffect;
import com.alternative_twilight.at_mod.effect.BloodLustEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.alternative_twilight.at_mod.AlternativeTwilight.MOD_ID;

/**
 * 状态效果注册中心。
 *
 * <p>注册名与语言键（{@code effect.at_mod.<name>}）及贴图
 * （{@code assets/at_mod/textures/mob_effect/<name>.png}）对应。
 */
public final class ModEffects {

    public static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(Registries.MOB_EFFECT, MOD_ID);

    /** 嗜血：增益，随等级提升攻击与移速（数值见 Config bloodLust 节） */
    public static final DeferredHolder<MobEffect, MobEffect> BLOOD_LUST =
            EFFECTS.register("blood_lust", BloodLustEffect::new);

    /** 嗜血诅咒：诅咒，到期按等级结算真实伤害（数值见 Config bloodLustCurse 节） */
    public static final DeferredHolder<MobEffect, MobEffect> BLOOD_LUST_CURSE =
            EFFECTS.register("blood_lust_curse", BloodCurseEffect::new);

    public static void register(IEventBus bus) {
        EFFECTS.register(bus);
    }

    private ModEffects() {
    }
}
