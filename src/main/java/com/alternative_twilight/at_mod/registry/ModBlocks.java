package com.alternative_twilight.at_mod.registry;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.alternative_twilight.at_mod.AlternativeTwilight.MOD_ID;

/**
 * 方块注册中心。
 *
 * <p>旧项目的 {@code example_block} 为试验内容，按迁移指南不迁移。
 * 新增方块时在此登记，并同时更新 {@link ModItems} 的 BlockItem 与语言文件。
 */
public final class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MOD_ID);

    // TODO: 按需登记方块

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }

    private ModBlocks() {
    }
}
