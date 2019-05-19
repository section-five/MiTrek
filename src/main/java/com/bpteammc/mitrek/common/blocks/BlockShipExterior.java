package com.bpteammc.mitrek.common.blocks;

import com.bpteammc.mitrek.common.tileentity.exteriors.TileShipExterior_01;
import com.bpteammc.mitrek.util.IHasModel;
import com.bpteammc.mitrek.common.tileentity.TileEntityShipExterior;
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
        return new TileShipExterior_01();
    }
}
