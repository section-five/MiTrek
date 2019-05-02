package com.ukminecrafted.mitrek.common.items;

import com.ukminecrafted.mitrek.Mitrek;
import com.ukminecrafted.mitrek.init.ModItems;
import com.ukminecrafted.mitrek.util.IHasModel;
import net.minecraft.item.ItemFood;

public class FoodBase extends ItemFood implements IHasModel
{

    public FoodBase(String name, int amount, float saturation, boolean isAnimalFood)
    {
        super(amount, saturation, isAnimalFood);
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(Mitrek.items);

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels()
    {
        Mitrek.proxy.registerItemRenderer(this, 0, "inventory");
    }

}