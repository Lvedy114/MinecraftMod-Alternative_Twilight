package com.alternative_twilight.at_mod.registry;

import com.alternative_twilight.at_mod.AlternativeTwilight;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * 音效事件注册中心。
 *
 * <p>注册名与 {@code assets/at_mod/sounds.json} 中的键一一对应（Boss 战斗音乐，stream 播放），
 * 音频文件位于 {@code assets/at_mod/sounds/music/}。
 */
public final class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(Registries.SOUND_EVENT, AlternativeTwilight.MOD_ID);

    public static final DeferredHolder<SoundEvent, SoundEvent> NAGA_MUSIC =
            registerMusic("music.naga");

    public static final DeferredHolder<SoundEvent, SoundEvent> LICH_MUSIC =
            registerMusic("music.lich");

    public static final DeferredHolder<SoundEvent, SoundEvent> HYDRA_MUSIC =
            registerMusic("music.hydra");

    public static final DeferredHolder<SoundEvent, SoundEvent> UR_GHAST_MUSIC =
            registerMusic("music.ur_ghast");

    public static final DeferredHolder<SoundEvent, SoundEvent> KNIGHT_PHANTOM_MUSIC =
            registerMusic("music.knight_phantom");

    public static final DeferredHolder<SoundEvent, SoundEvent> SNOW_QUEEN_MUSIC =
            registerMusic("music.snow_queen");

    public static final DeferredHolder<SoundEvent, SoundEvent> MINOSHROOM_MUSIC =
            registerMusic("music.minoshroom");

    public static final DeferredHolder<SoundEvent, SoundEvent> ALPHA_YETI_MUSIC =
            registerMusic("music.alpha_yeti");

    private static DeferredHolder<SoundEvent, SoundEvent> registerMusic(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(
                ResourceLocation.fromNamespaceAndPath(AlternativeTwilight.MOD_ID, name)));
    }

    public static void register(IEventBus bus) {
        SOUND_EVENTS.register(bus);
    }

    private ModSounds() {
    }
}
