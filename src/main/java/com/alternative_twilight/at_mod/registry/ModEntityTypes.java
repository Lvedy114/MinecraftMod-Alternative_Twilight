package com.alternative_twilight.at_mod.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.alternative_twilight.at_mod.AlternativeTwilight.MOD_ID;

/**
 * 实体类型注册中心。
 *
 * <p>计划登记：{@code naga_venom}（娜迦毒液投射物，见 boss/naga 域）。
 * 旧项目的其余实验性实体按迁移指南不迁移。
 */
public final class ModEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, MOD_ID);

    // TODO: 迁移 NagaVenomEntity 后在此登记：
    // public static final DeferredHolder<EntityType<?>, EntityType<NagaVenomEntity>> NAGA_VENOM =
    //         ENTITY_TYPES.register("naga_venom", () -> EntityType.Builder.<NagaVenomEntity>of(NagaVenomEntity::new, MobCategory.MISC)
    //                 .sized(0.5F, 0.5F).clientTrackingRange(8).updateInterval(10)
    //                 .build(AlternativeTwilight.prefix("naga_venom").toString()));

    public static void register(IEventBus bus) {
        ENTITY_TYPES.register(bus);
    }

    private ModEntityTypes() {
    }
}
