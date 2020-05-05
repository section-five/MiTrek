package xyz.bpteam.mitrek.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import xyz.bpteam.mitrek.blocks.BlockBase;
import xyz.bpteam.mitrek.items.MItemBlock;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    public static final List<Block> BLOCKS = new ArrayList<>();


    public static final Block DILITHIUM_BLOCK = registerBlock(new BlockBase(Block.Properties.create(Material.IRON)), "dilithium_block").setGroup(ItemGroup.BUILDING_BLOCKS);
    public static final Block DILITHIUM_ORE = registerBlock(new BlockBase(Block.Properties.create(Material.IRON)), "dilithium_ore").setGroup(ItemGroup.BREWING);


    public static BlockBase registerBlock(BlockBase base, String name) {
        base.setRegistryName(name);
        BLOCKS.add(base);

        MItemBlock itemBlock = (MItemBlock) new MItemBlock(base).setRegistryName(name);
        base.setmItemBlock(itemBlock);
        ModItems.ITEMS.add(itemBlock);

        return base;
    }
}
