package xyz.bpteam.mitrek.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import xyz.bpteam.mitrek.MiTrek;


@Mod.EventBusSubscriber(bus= Mod.EventBusSubscriber.Bus.MOD)
public class  ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, MiTrek.MODID);
    public static final RegistryObject<Block> DILITHIUM_BLOCK = BLOCKS.register("dilithium_block", () -> new Block(Block.Properties.create(Material.IRON)));
    public static final RegistryObject<Block> DILITHIUM_ORE = BLOCKS.register("dilithium_ore", () -> new Block(Block.Properties.create(Material.EARTH)));
    public static final RegistryObject<Block> DURITANIUM_BLOCK = BLOCKS.register("light_block", () -> new Block(Block.Properties.create(Material.IRON)));
    public static final RegistryObject<Block> DURITANIUM_ORE = BLOCKS.register("duritanium_ore", () -> new Block(Block.Properties.create(Material.EARTH)));
    public static final RegistryObject<Block> TOS_WARP_CORE = BLOCKS.register("tos_warp_core", () -> new Block(Block.Properties.create(Material.BARRIER)));

    @SubscribeEvent
    public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();
        BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            registry.register(new BlockItem(block, new Item.Properties().group(ModItemGroups.MITREK_ITEM)).setRegistryName(block.getRegistryName()));
        });
    }
}
