package io.github.bpteammc.mitrek.common.items;

import io.github.bpteammc.mitrek.Mitrek;
import io.github.bpteammc.mitrek.init.ModItems;
import io.github.bpteammc.mitrek.util.IHasModel;
import io.github.bpteammc.mitrek.util.helper.ShootWeapon;
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
        setCreativeTab(Mitrek.items);

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
