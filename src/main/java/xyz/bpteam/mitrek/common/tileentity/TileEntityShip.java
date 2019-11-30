/**
        All code copyright (C) BP Team 2019.
        All rights reserved.
        Contact support@bpteam.xyz for more info
**/
package com.bpteammc.mitrek.common.tileentity;

import com.bpteammc.mitrek.init.ModBlocks;
import com.bpteammc.mitrek.init.ModDimensions;
import com.bpteammc.mitrek.util.helper.Teleporter;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class TileEntityShip extends TileEntity implements ITickable {

    private int shipID = 0;
    private ShipData shipData;


    public TileEntityShip() {
    }


    public void setShipData(ShipData shipData) {
        this.shipData = shipData;
    }

    @Override
    public void update() {
        if (world == null) return;


        if(shipData == null && !world.isRemote) {
            setShipData(ShipHelper.getServerData(shipID, getPos()));
        }
    }

    public ShipData getShipData() {
        return shipData;
    }


    public int getShipID() {
        return shipID;
    }

    public void setShipID(int shipID) {
        this.shipID = shipID;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        shipID = compound.getInteger("shipID");
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        net.minecraft.util.math.AxisAlignedBB bb = INFINITE_EXTENT_AABB;
        return bb;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("shipID", shipID);
        return compound;
    }
}
