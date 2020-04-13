package xyz.bpteam.mitrek.tileentitys.exteriors;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;

public class TileExterior extends TileEntity {

    private int shipID = 0;
    private boolean inwarp = false;
    private int warppeed = 0;
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

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public void setOwnerUUID(String ownerUUID) {
        this.ownerUUID = ownerUUID;
    }
}
