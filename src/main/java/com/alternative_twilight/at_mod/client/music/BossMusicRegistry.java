package com.alternative_twilight.at_mod.client.music;

import com.alternative_twilight.at_mod.config.Config;
import com.alternative_twilight.at_mod.registry.ModSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import twilightforest.entity.boss.AlphaYeti;
import twilightforest.entity.boss.Hydra;
import twilightforest.entity.boss.KnightPhantom;
import twilightforest.entity.boss.Lich;
import twilightforest.entity.boss.Minoshroom;
import twilightforest.entity.boss.Naga;
import twilightforest.entity.boss.SnowQueen;
import twilightforest.entity.boss.UrGhast;

import java.util.List;
import java.util.function.Supplier;

/**
 * Boss 音乐数据表（仅客户端）。
 *
 * <p>新增曲目只需在此登记一行，不要复制 Boss 专属类（旧项目的
 * LichBossMusic / NagaBossMusic / ... 已按此原则合并为数据表）。
 */
public final class BossMusicRegistry {

    public static final List<BossMusicDefinition<?>> DEFINITIONS = List.of(
            define("naga", Naga.class, ModSounds.NAGA_MUSIC,
                    Config.MUSIC_ENABLED, Config.MUSIC_DETECTION_RADIUS, Config.MUSIC_VOLUME),
            define("lich", Lich.class, ModSounds.LICH_MUSIC,
                    Config.LICH_MUSIC_ENABLED, Config.LICH_MUSIC_DETECTION_RADIUS, Config.LICH_MUSIC_VOLUME),
            define("hydra", Hydra.class, ModSounds.HYDRA_MUSIC,
                    Config.HYDRA_MUSIC_ENABLED, Config.HYDRA_MUSIC_DETECTION_RADIUS, Config.HYDRA_MUSIC_VOLUME),
            define("ur_ghast", UrGhast.class, ModSounds.UR_GHAST_MUSIC,
                    Config.UR_GHAST_MUSIC_ENABLED, Config.UR_GHAST_MUSIC_DETECTION_RADIUS, Config.UR_GHAST_MUSIC_VOLUME),
            define("knight_phantom", KnightPhantom.class, ModSounds.KNIGHT_PHANTOM_MUSIC,
                    Config.KNIGHT_PHANTOM_MUSIC_ENABLED, Config.KNIGHT_PHANTOM_MUSIC_DETECTION_RADIUS, Config.KNIGHT_PHANTOM_MUSIC_VOLUME),
            define("snow_queen", SnowQueen.class, ModSounds.SNOW_QUEEN_MUSIC,
                    Config.SNOW_QUEEN_MUSIC_ENABLED, Config.SNOW_QUEEN_MUSIC_DETECTION_RADIUS, Config.SNOW_QUEEN_MUSIC_VOLUME),
            define("minoshroom", Minoshroom.class, ModSounds.MINOSHROOM_MUSIC,
                    Config.MINOSHROOM_MUSIC_ENABLED, Config.MINOSHROOM_MUSIC_DETECTION_RADIUS, Config.MINOSHROOM_MUSIC_VOLUME),
            define("alpha_yeti", AlphaYeti.class, ModSounds.ALPHA_YETI_MUSIC,
                    Config.ALPHA_YETI_MUSIC_ENABLED, Config.ALPHA_YETI_MUSIC_DETECTION_RADIUS, Config.ALPHA_YETI_MUSIC_VOLUME)
    );

    private static <E extends LivingEntity> BossMusicDefinition<E> define(String id, Class<E> entityClass,
            Supplier<SoundEvent> sound, Supplier<Boolean> enabled, Supplier<Double> radius, Supplier<Double> volume) {
        return new BossMusicDefinition<>(id, entityClass, sound, enabled::get, radius::get, volume::get);
    }

    private BossMusicRegistry() {
    }
}
