package xyz.bpteam.mitrek.items;

import net.minecraft.item.Item;
import xyz.bpteam.mitrek.init.ModItemGroups;

public class ItemBase extends Item {
    public ItemBase() {
        super(new Properties().group(ModItemGroups.MITREK_ITEMS));
    }
}
