package xyz.bpteam.mitrek.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public final class ModItemGroups {

    public static final ItemGroup MITREK_BLOCKS = new ItemGroup("mitrek_blocks") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.DILITHIUM_BLOCK.get().asItem());
        }
    };

    public static final ItemGroup MITREK_ITEMS = new ItemGroup("mitrek_items") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.DURITANIUM_ALLOY.get().asItem());
        }
    };
}