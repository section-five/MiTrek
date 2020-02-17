package xyz.bpteam.mitrek.common.items;

import xyz.bpteam.mitrek.Mitrek;
import xyz.bpteam.mitrek.init.ModItems;
import xyz.bpteam.mitrek.util.IHasModel;
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
