/*
        All code copyright (C) BP Team 2019.
        All rights reserved.
        Contact bpteammc@gmail.com for more info
*/
package io.github.bpteammc.mitrek.common.blocks;

import io.github.bpteammc.mitrek.Mitrek;
import io.github.bpteammc.mitrek.init.ModBlocks;
import io.github.bpteammc.mitrek.init.ModItems;
import io.github.bpteammc.mitrek.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {
    public BlockBase(String name, Material material) {
        super(material);
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(Mitrek.blocks);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        Mitrek.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
