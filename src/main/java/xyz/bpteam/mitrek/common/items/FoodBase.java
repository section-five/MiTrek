/*
        All code copyright (C) BP Team 2019.
        All rights reserved.
        Contact support@bpteam.xyz for more info
*/
package xyz.bpteam.mitrek.common.items;

import xyz.bpteam.mitrek.Mitrek;
import xyz.bpteam.mitrek.init.ModItems;
import xyz.bpteam.mitrek.util.IHasModel;
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