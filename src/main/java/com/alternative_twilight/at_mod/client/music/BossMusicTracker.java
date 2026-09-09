package com.alternative_twilight.at_mod.client.music;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SoundInstance;

/**
 * Boss 战斗音乐播放器（仅客户端）。
 *
 * <p>职责（对齐旧 BossMusicManager，见 docs/架构设计.md）：
 * <ul>
 *   <li>每 10 tick 检查本地玩家与 {@link BossMusicRegistry#DEFINITIONS} 中各 Boss 的距离</li>
 *   <li>命中（enabled 且距离 ≤ radius 且 filter 通过）则确保唯一的活动循环实例在播放</li>
 *   <li>未命中则停止；客户端登出时停止全部实例</li>
 * </ul>
 */
public final class BossMusicTracker {

    /** 同一时刻唯一的活动循环实例 */
    private static SoundInstance activeMusic;

    private BossMusicTracker() {
    }

    /** 由客户端 tick 事件每 10 tick 调用一次 */
    public static void tick(LocalPlayer player) {
        // TODO: 迁移旧 BossMusicManager 的检测与切换逻辑（数据来源 BossMusicRegistry.DEFINITIONS）
    }

    /** 客户端登出时停止全部实例 */
    public static void stopAll() {
        // TODO: 停止 activeMusic 并置空
    }
}
