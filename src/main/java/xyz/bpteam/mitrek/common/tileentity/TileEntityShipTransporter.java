package xyz.bpteam.mitrek.common.tileentity;

import xyz.bpteam.mitrek.init.ModDimensions;
import xyz.bpteam.mitrek.util.helper.Teleporter;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;

public class TileEntityShipTransporter extends TileEntity implements ITickable {

    private BlockPos exteriorpos = BlockPos.ORIGIN;
    private int exteriordimension = 0;

    public void ExitShip(EntityPlayerMP player) {
        if(player.dimension != ModDimensions.MITREKID)
        {
            world.getMinecraftServer().getPlayerList().transferPlayerToDimension(player, getExteriordimension(), new Teleporter(new BlockPos(pos.getX(), pos.getY(), pos.getZ())));
            player.connection.setPlayerLocation(getExteriorpos().getX(), getExteriorpos().getY() + 1, getExteriorpos().getZ(), 1, 1);
        }
    }

    public BlockPos getExteriorpos() {
        return exteriorpos;
    }

    public int getExteriordimension() {
        return exteriordimension;
    }

    @Override
    public void update() {
        if (!world.isRemote) {
        }
    }
}