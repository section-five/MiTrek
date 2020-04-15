package xyz.bpteam.mitrek.init;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import xyz.bpteam.mitrek.MiTrek;
import xyz.bpteam.mitrek.items.ItemBase;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, MiTrek.MODID);
    public static final RegistryObject<Item> DILITHIUM_CRYSTAL = ITEMS.register("dilithium_crystal", ItemBase::new);
}
