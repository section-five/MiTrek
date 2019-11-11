/*
        All code copyright (C) BP Team 2019.
        All rights reserved.
        Contact support@bpteam.xyz for more info
*/
package xyz.bpteam.mitrek.common.blocks;

import xyz.bpteam.mitrek.common.tileentity.TileEntityShip;
import xyz.bpteam.mitrek.util.IHasModel;
import xyz.bpteam.mitrek.util.handlers.SoundsHandler;
import xyz.bpteam.mitrek.util.helper.ShipHelper;
import xyz.bpteam.mitrek.util.helper.Teleporter;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockShipDoor extends BlockBase implements IHasModel {

    public BlockShipDoor(String name, Material material) {
        super(name, material);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        TileEntityShip ship = (TileEntityShip) worldIn.getTileEntity(ShipHelper.getShip(pos));
        if (playerIn instanceof EntityPlayerMP) {
            EntityPlayerMP player = (EntityPlayerMP) playerIn;
            worldIn.getMinecraftServer().getPlayerList().transferPlayerToDimension(player, ship.getDimension(), new Teleporter(new BlockPos(pos.getX(), pos.getY(), pos.getZ())));
            player.connection.setPlayerLocation(ship.getExteriorPos().getX() + 1, ship.getExteriorPos().getY(), ship.getExteriorPos().getZ(), 1, 1);
            playerIn.playSound(SoundsHandler.BEAM_IN, 1, 1);
        }
        return true;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.INVISIBLE;
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }
}