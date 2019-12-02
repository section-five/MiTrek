package com.bpteammc.mitrek.common.items;

import com.bpteammc.mitrek.Mitrek;
import com.bpteammc.mitrek.init.ModItems;
import com.bpteammc.mitrek.util.IHasModel;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

    public ItemBase(String name) {
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
