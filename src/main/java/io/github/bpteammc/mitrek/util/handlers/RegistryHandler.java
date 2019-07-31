package io.github.bpteammc.mitrek.util.handlers;

import io.github.bpteammc.mitrek.Mitrek;
import io.github.bpteammc.mitrek.client.renderers.RenderConstitutionExterior_01;
import io.github.bpteammc.mitrek.common.entity.EntityBeam;
import io.github.bpteammc.mitrek.common.tileentity.exteriors.TileShipExterior_01;
import io.github.bpteammc.mitrek.init.ModBlocks;
import io.github.bpteammc.mitrek.init.ModItems;
import io.github.bpteammc.mitrek.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber
public class RegistryHandler {

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        for (Item item : ModItems.ITEMS) {
            if (item instanceof IHasModel) {
                ((IHasModel) item).registerModels();
            }
        }
        for (Block block : ModBlocks.BLOCKS) {
            if (block instanceof IHasModel) {
                ((IHasModel) block).registerModels();
            }
        }
    }

    public static void registerTileEntity(Class<? extends TileEntity> clazz, String name) {
        GameRegistry.registerTileEntity(clazz, new ResourceLocation(Mitrek.MODID, name));
    }

    public static void preInit() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileShipExterior_01.class, new RenderConstitutionExterior_01());
    }

    public static void addEntities(RegistryEvent.Register<EntityEntry> e) {
        IForgeRegistry<EntityEntry> reg = e.getRegistry();
        reg.registerAll(EntityEntries.BEAM);
    }

    // Entities
    @GameRegistry.ObjectHolder(Mitrek.MODID)
    public static class EntityEntries {
        public static final EntityEntry BEAM = EntityEntryBuilder.create().entity(EntityBeam.class).id(new ResourceLocation(Mitrek.MODID, "ray"), 0).name("ray").tracker(80, 3, true).build();
    }
}
