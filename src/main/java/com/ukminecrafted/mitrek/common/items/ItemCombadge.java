package com.ukminecrafted.mitrek.common.items;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import baubles.api.cap.BaublesCapabilities;
import com.ukminecrafted.mitrek.Main;
import com.ukminecrafted.mitrek.init.ModItems;
import com.ukminecrafted.mitrek.util.IHasModel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class ItemCombadge extends Item implements IHasModel, IBauble {
    public ItemCombadge(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.items);

        ModItems.ITEMS.add(this);
    }




    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.BODY;
    }
}
