package com.bpteammc.mitrek.common.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;

public class TileEntityShip extends TileEntity implements ITickable {

    private boolean warping = false;
    private boolean isFlying = false;
    private BlockPos hullposition = BlockPos.ORIGIN;
    private BlockPos destination = BlockPos.ORIGIN;
    private BlockPos interiorposition = BlockPos.ORIGIN;

    private int dimension = 0;
    private int destinationdim = 0;

    // TODO Write things to nbt

    @Override
    public void update() {}

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        return compound;
    }
}
