package com.ukminecrafted.mitrek.common.items;

import com.ukminecrafted.mitrek.Main;
import com.ukminecrafted.mitrek.init.ModItems;
import com.ukminecrafted.mitrek.util.IHasModel;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;

import javax.tools.Tool;

public class WeaponBase extends ItemSword implements IHasModel
    {
        public WeaponBase(String name,ToolMaterial material) {
            super(material);
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(Main.items);

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {

    }
}
