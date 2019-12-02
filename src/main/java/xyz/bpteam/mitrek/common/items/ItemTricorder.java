package xyz.bpteam.mitrek.common.items;

import xyz.bpteam.mitrek.Mitrek;
import xyz.bpteam.mitrek.init.ModItems;
import xyz.bpteam.mitrek.util.IHasModel;
import net.minecraft.item.Item;

public class ItemTricorder extends Item implements IHasModel {

    public ItemTricorder(String name) {
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(Mitrek.items);
        setMaxStackSize(1);

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
        Mitrek.proxy.registerItemRenderer(this, 0, "inventory");
    }

}
