package com.ukminecrafted.mitrek.common.items;

import com.ukminecrafted.mitrek.Main;
import com.ukminecrafted.mitrek.init.ModItems;
import com.ukminecrafted.mitrek.util.IHasModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.client.event.MouseEvent;

public class ItemTricorder extends Item implements IHasModel {

    public ItemTricorder(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.items);

        ModItems.ITEMS.add(this);
    }


    /*@Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        int ree = 0;
        return super.onItemRightClick(worldIn, playerIn, handIn);
        if(ree == 0){
        }

    }*/

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }

}
