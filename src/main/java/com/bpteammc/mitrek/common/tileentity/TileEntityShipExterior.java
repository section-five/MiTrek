package com.bpteammc.mitrek.common.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public class TileEntityShipExterior extends TileEntity {

    private BlockPos interiorpos = BlockPos.ORIGIN;


    public void setInteriorpos(BlockPos pos)
    {
        this.interiorpos = pos;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
       interiorpos = BlockPos.fromLong(compound.getLong("interiorpos"));
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        net.minecraft.util.math.AxisAlignedBB bb = INFINITE_EXTENT_AABB;
        return bb;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setLong("interiorpos", interiorpos.toLong());
        return compound;
    }
}
