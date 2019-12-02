package xyz.bpteam.mitrek.common.blocks;

import xyz.bpteam.mitrek.Mitrek;
import xyz.bpteam.mitrek.init.ModBlocks;
import xyz.bpteam.mitrek.init.ModItems;
import xyz.bpteam.mitrek.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class LightBlockBase extends Block implements IHasModel {
    public LightBlockBase(String name, Material material) {
        super(material);
        setTranslationKey(name);
        setRegistryName(name);
        setLightLevel(1F);
        setCreativeTab(Mitrek.blocks);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        Mitrek.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

}