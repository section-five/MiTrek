/*
        All code copyright (C) BP Team 2019.
        All rights reserved.
        Contact support@bpteammc.com for more info
*/
package com.bpteammc.mitrek.common.items;


import com.bpteammc.mitrek.Mitrek;
import com.bpteammc.mitrek.init.ModItems;
import com.bpteammc.mitrek.util.IHasModel;
import net.minecraft.item.Item;

public class ItemCombadge extends Item implements IHasModel {
    public ItemCombadge(String name) {
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(Mitrek.items);
        setMaxStackSize(1);

        ModItems.ITEMS.add(this);
    }




    @Override
    public void registerModels() {
        Mitrek.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
