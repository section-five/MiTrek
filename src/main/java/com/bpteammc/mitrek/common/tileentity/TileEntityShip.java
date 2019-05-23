package com.bpteammc.mitrek.common.tileentity;

import com.bpteammc.mitrek.init.ModBlocks;
import com.bpteammc.mitrek.init.ModDimensions;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class TileEntityShip extends TileEntity implements ITickable {

    private boolean warping = false;
    private boolean isFlying = false;
    private BlockPos hullposition = BlockPos.ORIGIN;
    private BlockPos destination = BlockPos.ORIGIN;
    private BlockPos interiorposition = BlockPos.ORIGIN;
    private int exteriorid = 0;

    private int dimension = 0;
    private int destinationdim = 0;

    // TODO Write things to nbt

    public TileEntityShip() {
    }

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
        if (getDestinationdim() != ModDimensions.MITREKID) {
            if (isFlying) {
                World dim = getWorld().getMinecraftServer().getWorld(getDestinationdim());
                dim.setBlockState(destination, getExteriorState().getDefaultState());
                setHullData(dim);
                setExteriorToFade(true);
                setIsinFlight(false);
                setCurrentLocation(destination, destinationdim);
            }
        }else{
            for (EntityPlayerMP player : world.getEntitiesWithinAABB(EntityPlayerMP.class, Block.FULL_BLOCK_AABB.offset(getPos()).grow(16))) {
                player.sendStatusMessage(new TextComponentString("Can't land in the ship dimension!"), true);
            }
        }
    }

    public void spawnFirst() {
        if (getDestinationdim() != ModDimensions.MITREKID) {
            this.interiorposition = new BlockPos(getPos().getX() + 2.5, getPos().getY(), getPos().getZ() + 2.5);
            World dim = getWorld().getMinecraftServer().getWorld(getDestinationdim());
            dim.setBlockState(destination, getExteriorState().getDefaultState());
            setHullData(dim);
            setExteriorToFade(true);
            setIsinFlight(false);
            setCurrentLocation(destination, destinationdim);
        }
    }

    public void setHullposition(BlockPos pos) {
        this.hullposition = pos;
    }

    public BlockPos getHullposition() {
        return hullposition;
    }

    public int getDimension() {
        return dimension;
    }

    public int getExteriorid() {
        return exteriorid;
    }

    public void setDimension(int dim) {
        this.dimension = dim;
    }

    public void setCurrentLocation(BlockPos pos, int dim) {
        setHullposition(pos);
        setDimension(dim);
    }

    public Block getExteriorState() {
        if (this.exteriorid == 0) {
            return ModBlocks.SHIP_EXTERIOR;
        }
        return ModBlocks.SHIP_EXTERIOR;
    }


    public void setHullData(World dim) {
        if (dim.getTileEntity(destination) instanceof TileEntityShipExterior) {
            TileEntityShipExterior tileEntityShipExterior = (TileEntityShipExterior) dim.getTileEntity(destination);
            tileEntityShipExterior.setInteriorpos(interiorposition);
        }
    }

    public void setExteriorToFade(boolean fade) {
        World dim = world.getMinecraftServer().getWorld(dimension);
        if (dim.getTileEntity(hullposition) != null && dim.getTileEntity(hullposition) instanceof TileEntityShipExterior) {
            TileEntityShipExterior ship = (TileEntityShipExterior) dim.getTileEntity(hullposition);
            ship.setFading(fade);
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
        hullposition = BlockPos.fromLong(compound.getLong("hull_pos"));
        destination = BlockPos.fromLong(compound.getLong("destination_pos"));
        interiorposition = BlockPos.fromLong(compound.getLong("interior_pos"));
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
