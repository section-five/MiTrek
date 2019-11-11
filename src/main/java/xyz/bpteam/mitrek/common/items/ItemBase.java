/*
        All code copyright (C) BP Team 2019.
        All rights reserved.
        Contact support@bpteam.xyz for more info
*/
package xyz.bpteam.mitrek.common.items;

import xyz.bpteam.mitrek.Mitrek;
import xyz.bpteam.mitrek.init.ModItems;
import xyz.bpteam.mitrek.util.IHasModel;
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
