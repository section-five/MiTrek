package com.ukminecrafted.mitrek.common.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;

public class TileEntityShipExterior extends TileEntity {

    private BlockPos interiorpos = BlockPos.ORIGIN;

    // TODO Write things to nbt

    public void setInteriorpos(BlockPos pos) {
        this.interiorpos = pos;
    }

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
