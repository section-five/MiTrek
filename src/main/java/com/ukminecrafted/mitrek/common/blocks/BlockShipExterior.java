package com.ukminecrafted.mitrek.common.blocks;

import com.ukminecrafted.mitrek.common.tileentity.TileEntityShipExterior;
import com.ukminecrafted.mitrek.util.IHasModel;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockShipExterior extends BlockBase implements ITileEntityProvider, IHasModel {


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
        return new TileEntityShipExterior();
    }
}
