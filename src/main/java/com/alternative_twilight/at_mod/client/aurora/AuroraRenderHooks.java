package com.alternative_twilight.at_mod.client.aurora;

import net.minecraft.client.renderer.PostChain;

/**
 * 极光后处理链的渲染钩子（仅客户端）。
 *
 * <p>职责（对齐旧实现，见 docs/架构设计.md）：
 * <ul>
 *   <li>持有 {@link PostChain}（着色器定义位于 {@code assets/at_mod/shaders/post/aurora.json}）</li>
 *   <li>负责 PostChain 的创建、resize、uniform 更新与执行</li>
 *   <li>生命周期：资源重载前、Iris/Oculus 光影包激活时、效果不可用时关闭 PostChain</li>
 * </ul>
 *
 * <p>映射相关的兼容访问（PostChain pass 列表等）集中在本类适配，
 * 不向渲染代码散布反射；uniform 名与 {@code assets/at_mod/shaders/program/aurora.json} 保持同步。
 */
public final class AuroraRenderHooks {

    private AuroraRenderHooks() {
    }

    // TODO: 迁移旧 AuroraRenderHooks 的 PostChain 生命周期与 uniform 管理
}
