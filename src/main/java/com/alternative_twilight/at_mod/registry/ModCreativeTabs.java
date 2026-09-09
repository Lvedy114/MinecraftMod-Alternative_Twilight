package com.alternative_twilight.at_mod.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.alternative_twilight.at_mod.AlternativeTwilight.MOD_ID;

/**
 * 创造模式物品栏注册中心。
 *
 * <p>标题键：{@code itemGroup.at_mod}（置于原版战斗物品栏之后）。
 */
public final class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN_TAB =
            TABS.register("main", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.at_mod"))
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> ModItems.WOODEN_SPEAR.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.WOODEN_SPEAR.get());
                        output.accept(ModItems.STONE_SPEAR.get());
                        output.accept(ModItems.COPPER_SPEAR.get());
                        output.accept(ModItems.IRON_SPEAR.get());
                        output.accept(ModItems.GOLDEN_SPEAR.get());
                        output.accept(ModItems.DIAMOND_SPEAR.get());
                        output.accept(ModItems.NETHERITE_SPEAR.get());
                        output.accept(ModItems.IRONWOOD_SPEAR.get());
                        output.accept(ModItems.KNIGHT_SPEAR.get());
                    })
                    .build());

    public static void register(IEventBus bus) {
        TABS.register(bus);
    }

    private ModCreativeTabs() {
    }
}
