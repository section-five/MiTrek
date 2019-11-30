/*
        All code copyright (C) BP Team 2019.
        All rights reserved.
        Contact support@bpteammc.com for more info
*/
package com.bpteammc.mitrek.common.blocks;

import com.bpteammc.mitrek.Mitrek;
import com.bpteammc.mitrek.util.IHasModel;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;

public class BlockTOSCaptainsChair extends BlockBase implements IHasModel {

    public BlockTOSCaptainsChair(String name, Material material) {
        super(name, material);
        setCreativeTab(Mitrek.blocks);
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
