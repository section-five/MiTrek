package xyz.bpteam.mitrek.common.blocks;

import xyz.bpteam.mitrek.client.gui.ShipGUI;
import xyz.bpteam.mitrek.common.tileentity.TileEntityShip;
import xyz.bpteam.mitrek.util.IHasModel;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockConsole extends BlockBase implements ITileEntityProvider, IHasModel {

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            if (!playerIn.isSneaking()) {
                TileEntity tileEntity = world.getTileEntity(pos);
                if (!(tileEntity instanceof TileEntityShip)) {
                    return false;
                }
                Minecraft.getMinecraft().displayGuiScreen(new ShipGUI());
                return true;
            }
        }
        if (playerIn.isSneaking()) {
            if (world.isRemote) {
            }
        }
        return super.onBlockActivated(world, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }

    public BlockConsole(String name, Material material) {
        super(name, material);
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityShip();
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