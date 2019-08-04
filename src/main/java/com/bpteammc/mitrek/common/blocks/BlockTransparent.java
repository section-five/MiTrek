package com.bpteammc.mitrek.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumBlockRenderType;

public class BlockTransparent extends Block {
    public BlockTransparent(String name) {
        super(Material.BARRIER);
        setTranslationKey(name);
        setRegistryName(name);
        setLightLevel(1F);
        this.setResistance(6000001.0F);
        this.disableStats();
        this.translucent = true;
    }

    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.INVISIBLE;
    }

    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }
}
