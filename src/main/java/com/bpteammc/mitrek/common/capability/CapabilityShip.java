package com.bpteammc.mitrek.common.capability;

import com.bpteammc.mitrek.Mitrek;
import com.bpteammc.mitrek.network.NetworkManager;
import com.bpteammc.mitrek.network.packets.PacketCapSync;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import javax.annotation.Nonnull;

public class CapabilityShip implements IShipCapability {

    private EntityPlayer player;
    private int shipID;


    public CapabilityShip() {
    }


    public CapabilityShip(EntityPlayer player) {
        this.player = player;
    }

    @Override
    public void update() {
    }

    @Override
    public void sync() {
        if (!player.world.isRemote)
            NetworkManager.NETWORK.sendToAll(new PacketCapSync(player, serializeNBT()));
    }

    @Override
    public void setShipId(int id) {
        this.shipID = id;
    }

    @Override
    public int getShipId() {
        return shipID;
    }

    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setInteger("shipID", shipID);
        return nbt;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        shipID = nbt.getInteger("shipID");
    }

    @Mod.EventBusSubscriber(modid = Mitrek.MODID)
    public static class Events {

        @SubscribeEvent
        public static void attach(AttachCapabilitiesEvent<Entity> event) {
            if (event.getObject() instanceof EntityPlayer)
                event.addCapability(new ResourceLocation(Mitrek.MODID, "ship_cap"), new CapShipStorage.ShipCapProvider((EntityPlayer) event.getObject()));
        }

        @SubscribeEvent
        public static void update(LivingEvent.LivingUpdateEvent event) {
            CapabilityShip cap = event.getEntityLiving().getCapability(CapShipStorage.CAPABILITY, null);
            if (cap != null) {
                cap.update();
                cap.sync();
            }
        }

        @SubscribeEvent
        public static void onPlayerClone(PlayerEvent.Clone event) {
            Capability.IStorage storage = CapShipStorage.CAPABILITY.getStorage();

            IShipCapability oldCap = get(event.getOriginal());
            IShipCapability newCap = get(event.getEntityPlayer());

            NBTTagCompound nbt = (NBTTagCompound) storage.writeNBT(CapShipStorage.CAPABILITY, oldCap, null);
            storage.readNBT(CapShipStorage.CAPABILITY, newCap, null, nbt);
            get(event.getEntityPlayer()).sync();
        }

        @SubscribeEvent
        public static void playerTracking(PlayerEvent.StartTracking event) {
            get(event.getEntityPlayer()).sync();
        }
    }


    @SubscribeEvent
    public static void onPlayerRespawn(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent event) {
        get(event.player).sync();
    }


    @SubscribeEvent
    public static void onPlayerChangedDimension(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent event) {
        get(event.player).sync();
    }

    @SubscribeEvent
    public static void onDeathEvent(LivingDeathEvent e) {
        if (e.getEntityLiving() instanceof EntityPlayer) {
            get((EntityPlayer) e.getEntityLiving()).sync();
        }
    }

    @Nonnull
    public static IShipCapability get(EntityPlayer player) {
        if (player.hasCapability(CapShipStorage.CAPABILITY, null)) {
            return player.getCapability(CapShipStorage.CAPABILITY, null);
        }
        throw new IllegalStateException("Missing Capability - Mitrek");
    }
}
