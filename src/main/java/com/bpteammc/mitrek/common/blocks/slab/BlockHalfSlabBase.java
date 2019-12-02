package com.bpteammc.mitrek.common.blocks.slab;

import com.bpteammc.mitrek.Mitrek;
import com.bpteammc.mitrek.init.ModItems;
import com.bpteammc.mitrek.util.IHasModel;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;

public class BlockHalfSlabBase extends BlockSlabBase implements IHasModel
{
    public BlockHalfSlabBase(String name, Material materialIn, BlockSlab half, BlockSlab doubleSlab)
    {
        super(name, materialIn, half);

        ModItems.ITEMS.add(new ItemSlab(this, this, doubleSlab).setRegistryName(name));
    }

    @Override
    public boolean isDouble()
    {
        return false;
    }

    @Override
    public void registerModels() {
        Mitrek.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

}
