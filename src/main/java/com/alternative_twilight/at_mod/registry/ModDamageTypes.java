package com.alternative_twilight.at_mod.registry;

import com.alternative_twilight.at_mod.AlternativeTwilight;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;

/**
 * 自定义伤害类型的代码侧引用。
 *
 * <p>实际定义位于 {@code data/at_mod/damage_type/} 下的 JSON（数据驱动，无需注册中心），
 * 原版标签位于 {@code data/minecraft/tags/damage_type/}。
 * 本类只提供与 JSON 一致的 {@link ResourceKey} 常量，供伤害逻辑取 Holder 时使用。
 */
public final class ModDamageTypes {

    /** 矛突进造成的穿刺伤害（{@code at_mod:spear}） */
    public static final ResourceKey<DamageType> SPEAR = key("spear");

    /** 娜迦毒液的滞留伤害（{@code at_mod:naga_venom}） */
    public static final ResourceKey<DamageType> NAGA_VENOM = key("naga_venom");

    /** 嗜血诅咒到期结算的真实伤害（{@code at_mod:blood_curse}） */
    public static final ResourceKey<DamageType> BLOOD_CURSE = key("blood_curse");

    private ModDamageTypes() {
    }

    private static ResourceKey<DamageType> key(String name) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, AlternativeTwilight.prefix(name));
    }
}
