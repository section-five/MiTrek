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

    //resources
    public static final Item DURANIUM_INGOT = registerItem(new ItemBase(), "duranium_ingot").setGroup(ModItemGroups.MITREK_ITEMS);
    public static final Item MAGNESITE_INGOT = registerItem(new ItemBase(), "magnesite_ingot").setGroup(ModItemGroups.MITREK_ITEMS);
    public static final Item ELECTROCERAMICS = registerItem(new ItemBase(), "eleectroceramics").setGroup(ModItemGroups.MITREK_ITEMS);
    public static final Item VICTURIUM_INGOT = registerItem(new ItemBase(), "victurium_ingot").setGroup(ModItemGroups.MITREK_ITEMS);
    public static final Item TRITANIUM_INGOT = registerItem(new ItemBase(), "tritanium_ingot").setGroup(ModItemGroups.MITREK_ITEMS);
    public static final Item POLYDURANIDE_INGOT = registerItem(new ItemBase(), "polyduranide_ingot").setGroup(ModItemGroups.MITREK_ITEMS);


    public static <T extends Item> T registerItem(T item, String name) {
        item.setRegistryName(name);
        ITEMS.add(item);

        return item;
    }
}
