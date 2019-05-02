package com.ukminecrafted.mitrek.common.items;


import com.ukminecrafted.mitrek.Mitrek;
import com.ukminecrafted.mitrek.init.ModItems;
import com.ukminecrafted.mitrek.util.IHasModel;
import net.minecraft.item.Item;

public class ItemCombadge extends Item implements IHasModel {
    public ItemCombadge(String name) {
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(Mitrek.items);

        ModItems.ITEMS.add(this);
    }




    @Override
    public void registerModels() {
        Mitrek.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
