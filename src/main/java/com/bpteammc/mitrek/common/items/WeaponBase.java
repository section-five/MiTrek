package com.bpteammc.mitrek.common.items;

import com.bpteammc.mitrek.Mitrek;
import com.bpteammc.mitrek.init.ModItems;
import com.bpteammc.mitrek.util.IHasModel;
import net.minecraft.item.ItemSword;


public class WeaponBase extends ItemSword implements IHasModel
{
        public WeaponBase(String name,ToolMaterial material) {
            super(material);
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
