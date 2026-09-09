package com.alternative_twilight.at_mod.registry;

import com.alternative_twilight.at_mod.item.spear.SpearItem;
import com.alternative_twilight.at_mod.item.spear.SpearTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import twilightforest.util.TFToolMaterials;

import static com.alternative_twilight.at_mod.AlternativeTwilight.MOD_ID;

/**
 * 物品注册中心。
 *
 * <p>注册路径与资源一一对应：
 * {@code item.at_mod.spear.<name>}（语言）、{@code assets/at_mod/models/item/spear/<name>.json}（模型）、
 * {@code data/at_mod/recipe/spear/<name>.json}（配方）。
 *
 * <p>属性参数：{@code createAttributes(基础攻击力, 攻击速度修正, 交互距离加成)}，第三个参数为突进时的冲刺初速度。
 */
public final class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);

    public static final DeferredItem<Item> WOODEN_SPEAR = ITEMS.registerItem("spear/wooden_spear",
            props -> new SpearItem(Tiers.WOOD, props.attributes(SpearItem.createAttributes(2, -2.4, 1)), 2.0F));

    public static final DeferredItem<Item> STONE_SPEAR = ITEMS.registerItem("spear/stone_spear",
            props -> new SpearItem(Tiers.STONE, props.attributes(SpearItem.createAttributes(3, -2.8, 1.1)), 1.8F));

    public static final DeferredItem<Item> COPPER_SPEAR = ITEMS.registerItem("spear/copper_spear",
            props -> new SpearItem(SpearTiers.COPPER, props.attributes(SpearItem.createAttributes(3, -2.8, 1.1)), 1.7F));

    public static final DeferredItem<Item> IRON_SPEAR = ITEMS.registerItem("spear/iron_spear",
            props -> new SpearItem(Tiers.IRON, props.attributes(SpearItem.createAttributes(4, -3.0, 1.2)), 1.6F));

    public static final DeferredItem<Item> GOLDEN_SPEAR = ITEMS.registerItem("spear/golden_spear",
            props -> new SpearItem(SpearTiers.GOLDEN_SPEAR, props.attributes(SpearItem.createAttributes(2, -2.2, 1.0)), 2.1F));

    public static final DeferredItem<Item> DIAMOND_SPEAR = ITEMS.registerItem("spear/diamond_spear",
            props -> new SpearItem(Tiers.DIAMOND, props.attributes(SpearItem.createAttributes(5, -2.8, 1.2)), 1.75F));

    public static final DeferredItem<Item> NETHERITE_SPEAR = ITEMS.registerItem("spear/netherite_spear",
            props -> new SpearItem(Tiers.NETHERITE, props.attributes(SpearItem.createAttributes(6, -2.8, 1.3)), 1.8F));

    public static final DeferredItem<Item> IRONWOOD_SPEAR = ITEMS.registerItem("spear/ironwood_spear",
            props -> new SpearItem(TFToolMaterials.IRONWOOD, props.attributes(SpearItem.createAttributes(4, -2.4, 1.1)), 2.0F));

    public static final DeferredItem<Item> KNIGHT_SPEAR = ITEMS.registerItem("spear/knight_spear",
            props -> new SpearItem(TFToolMaterials.KNIGHTMETAL, props.attributes(SpearItem.createAttributes(6, -2.4, 1.3)), 2.1F));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

    private ModItems() {
    }
}
