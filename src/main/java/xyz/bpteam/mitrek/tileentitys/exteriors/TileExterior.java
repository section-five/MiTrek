package xyz.bpteam.mitrek.tileentitys.exteriors;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;

public class TileExterior extends TileEntity {

    private int shipID = 0;
    private boolean inwarp = false;
    private int warpspeed = 0;
    private boolean shiplocked = false;
    private String ownername;
    private String ownerUUID;

    //exterior info
    private BlockPos currentPos;
    private int currentDim;

    //destination info
    private BlockPos destinationPos;
    private int destinationDim;

    //interior info
    private BlockPos interiorPos;

    public TileExterior(TileEntityType<?> p_i48289_1_) {
        super(p_i48289_1_);
    }

    public int getShipID() {
        return shipID;
    }

    public boolean isInwarp() {
        return inwarp;
    }

    public int getWarpspeed() {
        return warpspeed;
    }

    public boolean isShiplocked() {
        return shiplocked;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public String getOwnerUUID() {
        return ownerUUID;
    }

    public void setOwnerUUID(String ownerUUID) {
        this.ownerUUID = ownerUUID;
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
