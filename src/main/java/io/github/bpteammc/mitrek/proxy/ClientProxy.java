/*
        All code copyright (C) BP Team 2019.
        All rights reserved.
        Contact bpteammc@gmail.com for more info
*/
package io.github.bpteammc.mitrek.proxy;

import io.github.bpteammc.mitrek.client.renderers.RenderConstitutionExterior_01;
import io.github.bpteammc.mitrek.common.tileentity.exteriors.TileShipExteriorConstitution;
import io.github.bpteammc.mitrek.util.handlers.RegistryHandler;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy implements IProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        RegistryHandler.preInit();
        ClientRegistry.bindTileEntitySpecialRenderer(TileShipExteriorConstitution.class, new RenderConstitutionExterior_01());

    }

    @Override
    public void init(FMLInitializationEvent event) {

    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }

    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
    }
}