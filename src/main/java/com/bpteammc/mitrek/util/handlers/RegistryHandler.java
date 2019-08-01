package com.bpteammc.mitrek.util.handlers;

import com.bpteammc.mitrek.Mitrek;
import com.bpteammc.mitrek.client.renderers.RenderConstitutionExterior_01;
import com.bpteammc.mitrek.common.entity.EntityBeam;
import com.bpteammc.mitrek.common.tileentity.exteriors.TileShipExterior_01;
import com.bpteammc.mitrek.init.ModBlocks;
import com.bpteammc.mitrek.init.ModItems;
import com.bpteammc.mitrek.util.IHasModel;
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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
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

    @SideOnly(Side.CLIENT)
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
