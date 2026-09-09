package com.alternative_twilight.at_mod.client.aurora;

/**
 * 幻影骑士极光效果的状态追踪器（仅客户端）。
 *
 * <p>职责（对齐旧实现，见 docs/架构设计.md）：
 * <ul>
 *   <li>判定效果是否激活：本地玩家与被召唤的幻影骑士距离 ≤
 *       {@code Config.PHANTOM_AURORA_DETECTION_RADIUS} 且 {@code PHANTOM_AURORA_ENABLED}</li>
 *   <li>为 {@link AuroraRenderHooks} 提供激活状态与锚点位置</li>
 * </ul>
 */
public final class PhantomAuroraTracker {

    private PhantomAuroraTracker() {
    }

    // TODO: 迁移旧 PhantomAuroraTracker 的激活判定与锚点维护
}
