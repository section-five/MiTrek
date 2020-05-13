package xyz.bpteam.mitrek.ship;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;

import java.util.UUID;

public class ShipData {
    private boolean inwarp = false;
    private int warpspeed = 0;
    private boolean shiplocked = false;

    //exterior info
    private BlockPos currentPos;
    private int currentDim;

    //destination info
    private BlockPos destinationPos;
    private int destinationDim;

    //interior info
    private BlockPos interiorPos;


    public boolean isInwarp() {
        return inwarp;
    }

    public int getWarpspeed() {
        return warpspeed;
    }

    public boolean isShiplocked() {
        return shiplocked;
    }


    public BlockPos getCurrentPos() {
        return currentPos;
    }

    public void setCurrentPos(BlockPos currentPos) {
        this.currentPos = currentPos;
    }

    public BlockPos getDestinationPos() {
        return destinationPos;
    }

    public BlockPos getInteriorPos() {
        return interiorPos;
    }

    public int getCurrentDim() {
        return currentDim;
    }

    public void setCurrentDim(int destinationDim) {
        this.destinationDim = destinationDim;
    }

    public int getDestinationDim() {
        return destinationDim;
    }
}
