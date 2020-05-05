package xyz.bpteam.mitrek.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import xyz.bpteam.mitrek.MiTrek;
import xyz.bpteam.mitrek.items.ItemBase;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final List<Item> ITEMS = new ArrayList<>();

    public static final Item DILITHIUM_CRYSTAL = registerItem(new ItemBase(), "dilithium_crystal").setGroup(ItemGroup.MISC);

    public static <T extends Item> T registerItem(T item, String name) {
        item.setRegistryName(name);
        ITEMS.add(item);

        return item;
    }
}
