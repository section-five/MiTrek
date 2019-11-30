package com.bpteammc.mitrek.common.blocks;

import com.bpteammc.mitrek.common.capability.CapShipStorage;
import com.bpteammc.mitrek.common.capability.IShipCapability;
import com.bpteammc.mitrek.common.ship.data.ShipData;
import com.bpteammc.mitrek.util.IHasModel;
import com.bpteammc.mitrek.util.helper.ShipHelper;
import com.bpteammc.mitrek.util.helper.Teleporter;
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
        if(!worldIn.isRemote) {
            IShipCapability capability = playerIn.getCapability(CapShipStorage.CAPABILITY, null);
            ShipData data = ShipHelper.getShip(capability.getShipId());

            if (playerIn instanceof EntityPlayerMP && data != null) {
                EntityPlayerMP player = (EntityPlayerMP) playerIn;
                worldIn.getMinecraftServer().getPlayerList().transferPlayerToDimension(player, data.getCurrentDimension(), new Teleporter(new BlockPos(pos.getX(), pos.getY(), pos.getZ())));
                player.connection.setPlayerLocation(data.getCurrentPosition().getX(), data.getCurrentPosition().getY(), data.getCurrentPosition().getZ(), 1 /* Needs to be exit rotation - 180*/, 1);
            }
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