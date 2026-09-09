package com.alternative_twilight.at_mod.event;

/**
 * 通用（双端）事件处理器骨架。
 *
 * <p>待迁移的事件（对齐旧项目）：
 * <ul>
 *   <li>{@code LichMinionSpawnHandler} —— 巫妖仆从生成时按 Config lichMinion 节调整属性</li>
 *   <li>{@code SpearEvents} —— 玩家被攻击后写入 {@link com.alternative_twilight.at_mod.item.spear.SpearItem#PROTECT_UNTIL_KEY}
 *       的被击保护期（时长 {@code Config.SPEAR_HIT_PROTECTION_TICKS}）</li>
 *   <li>{@code BloodLustEvents} —— 嗜血诅咒到期结算（委托 {@code effect/BloodCurseEffect} 的 TODO）</li>
 * </ul>
 *
 * <p>实现时使用 {@code @EventBusSubscriber(modid = "at_mod")} 挂到游戏总线，或集中注册到 {@code NeoForge.EVENT_BUS}。
 */
public final class CommonEvents {

    private CommonEvents() {
    }
}
