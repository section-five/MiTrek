/*
        All code copyright (C) BP Team 2019.
        All rights reserved.
        Contact support@bpteammc.com for more info
*/
package com.bpteammc.mitrek.common.items;

import com.bpteammc.mitrek.Mitrek;
import com.bpteammc.mitrek.init.ModItems;
import com.bpteammc.mitrek.util.IHasModel;
import com.bpteammc.mitrek.util.helper.ShootWeapon;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemPhaser extends Item implements IHasModel {

    public ItemPhaser(String name) {
        setTranslationKey(name);
        setRegistryName(name);
        setMaxStackSize(1);
        setCreativeTab(Mitrek.items);
        setMaxStackSize(1);

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Mitrek.proxy.registerItemRenderer(this, 0, "inventory");
    }


    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        playerIn.setActiveHand(handIn);
        ItemStack stack = playerIn.getActiveItemStack();
        ShootWeapon.Beam(playerIn, worldIn, stack);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
