package com.alternative_twilight.at_mod.client.music;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

/**
 * 暮色森林 Boss 与其战斗音乐的不可变数据绑定（仅客户端）。
 *
 * @param id          标识（与音效注册名对应，如 "lich"）
 * @param entityClass Boss 实体类
 * @param sound       音效事件
 * @param enabled     启用开关（来自配置）
 * @param radius      触发半径（格，来自配置）
 * @param volume      音量（0.0-1.0，来自配置）
 * @param filter      额外过滤条件（默认存活判定）
 */
public record BossMusicDefinition<E extends LivingEntity>(
        String id,
        Class<E> entityClass,
        Supplier<SoundEvent> sound,
        BooleanSupplier enabled,
        DoubleSupplier radius,
        DoubleSupplier volume,
        EntityFilter<E> filter
) {
    public BossMusicDefinition(String id, Class<E> entityClass, Supplier<SoundEvent> sound,
                               BooleanSupplier enabled, DoubleSupplier radius, DoubleSupplier volume) {
        this(id, entityClass, sound, enabled, radius, volume, (entity, player) -> entity.isAlive());
    }

    @FunctionalInterface
    public interface EntityFilter<E extends LivingEntity> {
        boolean matches(E entity, LocalPlayer player);
    }
}
