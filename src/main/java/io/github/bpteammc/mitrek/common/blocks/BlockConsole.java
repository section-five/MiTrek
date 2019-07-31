package io.github.bpteammc.mitrek.common.blocks;

import io.github.bpteammc.mitrek.util.IHasModel;
import io.github.bpteammc.mitrek.common.tileentity.TileEntityShip;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockConsole extends BlockBase implements ITileEntityProvider, IHasModel {


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
}
