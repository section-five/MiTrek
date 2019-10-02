/*
        All code copyright (C) BP Team 2019.
        All rights reserved.
        Contact bpteammc@gmail.com for more info
*/
package io.github.bpteammc.mitrek.common.world;

import io.github.bpteammc.mitrek.Mitrek;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;

import java.util.ArrayList;
import java.util.List;

public class InteriorGeneration {

    public static List<InteriorGeneration> INTERIOR_LIST = new ArrayList<>();

    private ResourceLocation location;
    private BlockPos console = BlockPos.ORIGIN;

    public InteriorGeneration(ResourceLocation location, BlockPos position) {
        this.location = location;
        this.console = position;
    }

    public void generate(WorldServer world, BlockPos pos) {
        Template template = world.getStructureTemplateManager().get(world.getMinecraftServer(), location);
        PlacementSettings placementSettings = new PlacementSettings();
        template.addBlocksToWorld(world, pos.subtract(console), placementSettings);
    }

    public static void registerConsoleRoom(String interiorName, BlockPos pos) {
        INTERIOR_LIST.add(new InteriorGeneration(new ResourceLocation(Mitrek.MODID, interiorName), pos));
    }
}
