package me.ukminecrafted.mitrek;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.ukminecrafted.mitrek.world.generation.OreGeneration;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import me.ukminecrafted.mitrek.init.ModBlocks;
import me.ukminecrafted.mitrek.init.ModItems;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("mitrek")
public class MiTrek {
    public static final String MODID = "mitrek";
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Logger LOGGER = LogManager.getLogger();
    public static MiTrek instance;

    public MiTrek() {
        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call

    @SubscribeEvent
    public void commonSetup(FMLCommonSetupEvent event) {
        OreGeneration.init();

    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event) {
            LOGGER.info("Registering Items");

            for (Item item : ModItems.ITEMS) {
                event.getRegistry().register(item);
            }
        }

        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event) {
            LOGGER.info("Registering Blocks");

            for (Block block : ModBlocks.BLOCKS) {
                event.getRegistry().register(block);
            }
        }
    }
}