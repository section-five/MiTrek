package com.bpteammc.mitrek.common.blocks.slab;


import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;

public class BlockDoubleSlabBase extends BlockSlabBase
{
    public BlockDoubleSlabBase(String name, Material materialIn, BlockSlab half)
    {
        super(name, materialIn, half);
    }

    @Override
    public boolean isDouble()
    {
        return true;
    }
}
