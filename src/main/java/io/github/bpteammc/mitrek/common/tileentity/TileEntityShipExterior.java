package io.github.bpteammc.mitrek.common.tileentity;

import jdk.nashorn.internal.ir.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public class TileEntityShipExterior extends TileEntity implements ITickable {

    private BlockPos interiorpos = BlockPos.ORIGIN;
    private BlockPos exteriorpos = BlockPos.ORIGIN;
    private float alpha = 1.0f;
    private boolean isRemat, isDemat = false;


    public TileEntityShipExterior() {
        this.isRemat = true;
        this.alpha = 0.0f;
    }

    public float getAlpha() {
        return alpha;
    }

    public BlockPos getInteriorpos() {
        return interiorpos;
    }

    public BlockPos getExteriorpos() {
        return exteriorpos;
    }


    @Override
    public void update() {
        if (world == null) return;
        if (isRemat) {
            if (alpha < 1.0f) {
                alpha += 0.005f;
            }
            if (alpha >= 1.0f) this.isRemat = false;
        }

        if (isDemat) {
            alpha -= 0.005f;
            if (alpha <= 0) {
                world.setBlockToAir(getPos());
            }
        }
        if (!this.isRemat && !this.isDemat) this.alpha = 1.0F;
    }

    public void setFading(boolean fading) {
       if(fading) {
           isDemat = true;
       }else{
           isRemat = true;
       }
    }

    public void setInteriorpos(BlockPos pos)
    {
        this.interiorpos = pos;
    }

    public void setExteriorpos(BlockPos pos) {
        this.exteriorpos = pos;
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
