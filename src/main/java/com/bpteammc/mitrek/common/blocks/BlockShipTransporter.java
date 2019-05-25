package com.bpteammc.mitrek.common.blocks;

import com.bpteammc.mitrek.common.tileentity.TileEntityShip;
import com.bpteammc.mitrek.common.tileentity.TileEntityShipExterior;
import com.bpteammc.mitrek.util.IHasModel;
import com.bpteammc.mitrek.util.helper.Teleporter;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockShipTransporter extends BlockBase implements IHasModel {
    private int exteriordimension = 0;

    public BlockShipTransporter(String name, Material material) {
        super(name, material);
    }


    /*@Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        TileEntityShipTransporter transporter = (TileEntityShipTransporter) worldIn.getTileEntity(pos);
        if (playerIn instanceof EntityPlayerMP) {
            EntityPlayerMP player = (EntityPlayerMP) playerIn;
            transporter.ExitShip(player);
        }
        return true;
    }*/

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
            TileEntityShipExterior ship = (TileEntityShipExterior) worldIn.getTileEntity(pos);

            if (playerIn instanceof EntityPlayerMP) {
                EntityPlayerMP player = (EntityPlayerMP) playerIn;
                worldIn.getMinecraftServer().getPlayerList().transferPlayerToDimension(player, this.exteriordimension, new Teleporter(new BlockPos(pos.getX(), pos.getY(), pos.getZ())));
                player.connection.setPlayerLocation(ship.getExteriorpos().getX() + 1, ship.getExteriorpos().getY(), ship.getExteriorpos().getZ(), 1, 1);
            }
        return true;
    }
}