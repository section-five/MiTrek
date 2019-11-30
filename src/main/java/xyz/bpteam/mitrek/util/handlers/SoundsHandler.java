/*
        All code copyright (C) BP Team 2019.
        All rights reserved.
        Contact support@bpteam.xyz for more info
*/
package xyz.bpteam.mitrek.util.handlers;

import xyz.bpteam.mitrek.Mitrek;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundsHandler {

    public static SoundEvent TOS_SHOOT;
    public static SoundEvent BEAM_IN;

    public static void registerSounds() {
        TOS_SHOOT = registerSound("tos_shoot");
        BEAM_IN = registerSound("beam_in");
    }

    private static SoundEvent registerSound(String name) {
        ResourceLocation location = new ResourceLocation(Mitrek.MODID, name);
        SoundEvent event = new SoundEvent(location);
        event.setRegistryName(name);
        ForgeRegistries.SOUND_EVENTS.register(event);
        return event;
    }
}