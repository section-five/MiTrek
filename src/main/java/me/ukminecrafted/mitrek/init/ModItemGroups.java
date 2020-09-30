package me.ukminecrafted.mitrek.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public final class ModItemGroups {

    public static final ItemGroup MITREK_BLOCKS = new ItemGroup("mitrek_blocks") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.DILITHIUM_BLOCK);
        }
    };

    public static final ItemGroup MITREK_ITEMS = new ItemGroup("mitrek_items") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.DURANIUM_INGOT);
        }
    };
}