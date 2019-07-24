package com.bpteammc.mitrek.common.blocks;

import com.bpteammc.mitrek.Mitrek;
import com.bpteammc.mitrek.client.gui.ShipGUI;
import com.bpteammc.mitrek.util.IHasModel;
import com.bpteammc.mitrek.common.tileentity.TileEntityShip;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class BlockConsole extends BlockBase implements ITileEntityProvider, IHasModel {

    public static final int GUI_ID = 1;

    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack helditem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            return true;
        }
        TileEntity tileEntity = world.getTileEntity(pos);
        if (!(tileEntity instanceof TileEntityShip)) {
            return false;
        }
        BlockConsole.OpenShipGui(player);
        return true;
    }


    public BlockConsole(String name, Material material) {
        super(name, material);
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public static void OpenShipGui(EntityPlayer playerIn) {
            Minecraft.getMinecraft().displayGuiScreen(new ShipGUI());
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityShip();
    }
}
