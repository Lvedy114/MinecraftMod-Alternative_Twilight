package com.alternative_twilight.at_mod.mixin.naga;

import org.spongepowered.asm.mixin.Mixin;
import twilightforest.entity.boss.Naga;

/**
 * 娜迦注入层（薄 Mixin，仅挂钩，业务计算在 {@link com.alternative_twilight.at_mod.boss.naga.NagaCombatManager}）。
 *
 * <p>待迁移的注入点（对齐旧 NagaMixin / NagaMovementPatternMixin）：
 * <ul>
 *   <li>{@code hurt} —— 愤怒冲刺期间的正面攻击眩晕判定与受伤倍率</li>
 *   <li>冲撞发动点 —— 每次冲撞发射毒液（配合 NagaVenomEntity）</li>
 *   <li>{@code NagaMovementPattern}（另立 mixin）—— 按生命阈值替换普通冲撞为愤怒冲撞</li>
 * </ul>
 */
@Mixin(Naga.class)
public abstract class NagaMixin {
    // TODO: 迁移注入方法，业务计算委托 NagaCombatManager。
}
