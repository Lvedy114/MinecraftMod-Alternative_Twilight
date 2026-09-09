package com.alternative_twilight.at_mod.client.event;

import com.alternative_twilight.at_mod.AlternativeTwilight;
import com.alternative_twilight.at_mod.item.spear.SpearClientExtensions;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

/**
 * 客户端事件注册（仅客户端加载，禁止被 common 引用）。
 *
 * <p>事件总线由 NeoForge 按事件类型自动路由（本类中的 RegisterClientExtensionsEvent
 * 属于模组总线事件），无需显式指定 bus。
 */
@EventBusSubscriber(modid = AlternativeTwilight.MOD_ID, value = Dist.CLIENT)
public final class ClientEvents {

    private ClientEvents() {
    }

    /** 注册矛类客户端扩展（持矛姿态） */
    @SubscribeEvent
    public static void onRegisterClientExtensions(RegisterClientExtensionsEvent event) {
        SpearClientExtensions.registerSpearPoses(event);
    }

    // TODO: Boss 音乐的客户端 tick 驱动（每 10 tick 调用 BossMusicTracker.tick，见 docs/架构设计.md）
    // TODO: 极光渲染的生命周期挂接（PhantomAuroraTracker / AuroraRenderHooks）
}
