package com.alternative_twilight.at_mod;

import com.alternative_twilight.at_mod.config.Config;
import com.alternative_twilight.at_mod.registry.ModBlocks;
import com.alternative_twilight.at_mod.registry.ModCreativeTabs;
import com.alternative_twilight.at_mod.registry.ModEffects;
import com.alternative_twilight.at_mod.registry.ModEntityTypes;
import com.alternative_twilight.at_mod.registry.ModItems;
import com.alternative_twilight.at_mod.registry.ModSounds;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import org.slf4j.Logger;

import java.util.Locale;

/**
 * Alternative Twilight 主入口。
 *
 * <p>本模组是暮色森林（Twilight Forest）的附属模组，核心业务包括：
 * 矛类武器、Boss 机制修改（巫妖/娜迦）、Boss 战斗音乐、极光着色器特效与新 Buff。
 *
 * <p>结构规则见 {@code docs/架构设计.md}，迁移状态见 {@code docs/迁移指南.md}。
 * 本类只做装配：注册中心统一收敛在 {@code registry/}，不在主类中散写注册。
 */
@Mod(AlternativeTwilight.MOD_ID)
public class AlternativeTwilight {

    /** 模组 ID，同时是资源与数据的命名空间 */
    public static final String MOD_ID = "at_mod";

    public static final Logger LOGGER = LogUtils.getLogger();

    public AlternativeTwilight(IEventBus modEventBus, ModContainer modContainer) {
        // 注册中心（顺序无强依赖，按 registry 包内各类聚合装配）
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
        ModEntityTypes.register(modEventBus);
        ModSounds.register(modEventBus);
        ModEffects.register(modEventBus);

        // 通用配置（at_mod_config.toml）
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC, "at_mod_config.toml");

        LOGGER.info("Alternative Twilight loaded.");
    }

    /** 构造本模组命名空间下的 ResourceLocation，路径自动转小写 */
    public static ResourceLocation prefix(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name.toLowerCase(Locale.ROOT));
    }
}
