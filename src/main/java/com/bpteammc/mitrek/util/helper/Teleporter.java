package com.bpteammc.mitrek.util.helper;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ITeleporter;

public class Teleporter implements ITeleporter {

    private final BlockPos pos;

    public Teleporter(BlockPos targetPos) {
        this.pos = targetPos;
    }
    public void placeEntity(World world, Entity entity, float yaw) {
        entity.moveToBlockPosAndAngles(pos, yaw, entity.rotationPitch);
    }
}
