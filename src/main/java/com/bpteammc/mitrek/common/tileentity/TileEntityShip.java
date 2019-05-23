package com.bpteammc.mitrek.common.tileentity;

import com.bpteammc.mitrek.init.ModDimensions;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

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
    public void update() {

    }

    public void setDestination(BlockPos destination1, int dim) {
        this.destination = destination1;
        this.destinationdim = dim;
    }

    public void setIsinFlight(boolean inFlight) {
        this.isFlying = inFlight;
    }

    public void Land() {
        if(getDestinationdim() != ModDimensions.MITREKID) {
            if(isFlying) {
                World dim = getWorld().getMinecraftServer().getWorld(getDestinationdim());

            }
        }
    }

    public int getDestinationdim() {
        return destinationdim;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        warping = compound.getBoolean("warping");
        isFlying = compound.getBoolean("flying");
        hullposition  = BlockPos.fromLong(compound.getLong("hull_pos"));
        destination  = BlockPos.fromLong(compound.getLong("destination_pos"));
        interiorposition  = BlockPos.fromLong(compound.getLong("interior_pos"));
        dimension = compound.getInteger("dimension");
        destinationdim = compound.getInteger("destination_dim");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setBoolean("warping", warping);
        compound.setBoolean("flying", isFlying);
        compound.setLong("hull_pos", hullposition.toLong());
        compound.setLong("destination_pos", destination.toLong());
        compound.setLong("interior_pos", interiorposition.toLong());
        compound.setInteger("dimension", dimension);
        compound.setInteger("destination_dim", destinationdim);
        return compound;
    }
}
