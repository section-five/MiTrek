/*
        All code copyright (C) BP Team 2019.
        All rights reserved.
        Contact support@bpteam.xyz for more info
*/
package xyz.bpteam.mitrek.common.blocks;

import xyz.bpteam.mitrek.common.tileentity.TileEntityShipExterior;
import xyz.bpteam.mitrek.common.tileentity.exteriors.TileShipExteriorConstitution;
import xyz.bpteam.mitrek.init.ModDimensions;
import xyz.bpteam.mitrek.util.IHasModel;
import xyz.bpteam.mitrek.util.helper.ShipHelper;
import xyz.bpteam.mitrek.util.helper.Teleporter;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockShipExterior extends BlockBase implements ITileEntityProvider, IHasModel {

    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    public BlockShipExterior(String name, Material material) {
        super(name, material);
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileShipExteriorConstitution();
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.byHorizontalIndex(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getHorizontalIndex();
    }

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }


    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.INVISIBLE;
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public boolean isNormalCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(worldIn.getTileEntity(pos) instanceof TileEntityShipExterior) {
            TileEntityShipExterior shipExterior = (TileEntityShipExterior) worldIn.getTileEntity(pos);

            if (playerIn instanceof EntityPlayerMP) {
                EntityPlayerMP player = (EntityPlayerMP) playerIn;
                worldIn.getMinecraftServer().getPlayerList().transferPlayerToDimension(player, ModDimensions.MITREKID, new Teleporter(new BlockPos(pos.getX(), pos.getY(), pos.getZ())));
                player.connection.setPlayerLocation(shipExterior.getInteriorpos().getX(), shipExterior.getInteriorpos().getY() + 1, shipExterior.getInteriorpos().getZ(), 1, 1);
            }
        }

        return true;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);

        if (placer instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) placer;

            if (ShipHelper.hasShip(player.getUniqueID())) {
                worldIn.setBlockToAir(pos);
                player.sendStatusMessage(new TextComponentString("You already have a ship!"), true);
            } else {
                ShipHelper.makeShip(player, pos);
            }
        }
    }
}
