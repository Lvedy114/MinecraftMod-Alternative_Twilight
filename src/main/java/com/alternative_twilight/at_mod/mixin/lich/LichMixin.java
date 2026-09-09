package com.alternative_twilight.at_mod.mixin.lich;

import org.spongepowered.asm.mixin.Mixin;
import twilightforest.entity.boss.Lich;

/**
 * 巫妖注入层（薄 Mixin，仅挂钩，业务计算在 {@link com.alternative_twilight.at_mod.boss.lich.LichPhaseManager}）。
 *
 * <p>待迁移的注入点（对齐旧 LichMixin）：
 * <ul>
 *   <li>{@code customServerAiStep} TAIL —— 第三阶段法球召唤冷却、延迟生命扣除、轨迹粒子</li>
 *   <li>{@code hurt} —— 第二阶段伤害锁定为 1 点、僵尸数量达标立即进入第三阶段</li>
 *   <li>{@code actuallyHurt / breakShield 等护盾破坏点} —— 第一阶段破盾诅咒</li>
 *   <li>仆从生成属性 —— 与 {@code event/} 的 LichMinionSpawnHandler 配合</li>
 * </ul>
 */
@Mixin(Lich.class)
public abstract class LichMixin {
    // TODO: 迁移注入方法，业务计算委托 LichPhaseManager。
}
