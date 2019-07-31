package io.github.bpteammc.mitrek.common.items;

import io.github.bpteammc.mitrek.Mitrek;
import io.github.bpteammc.mitrek.init.ModItems;
import io.github.bpteammc.mitrek.util.IHasModel;
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
