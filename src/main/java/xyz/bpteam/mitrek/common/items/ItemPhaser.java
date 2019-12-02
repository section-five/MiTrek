package xyz.bpteam.mitrek.common.items;

import xyz.bpteam.mitrek.Mitrek;
import xyz.bpteam.mitrek.init.ModItems;
import xyz.bpteam.mitrek.util.IHasModel;
import xyz.bpteam.mitrek.util.helper.ShootWeapon;
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
