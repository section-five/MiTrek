package com.bpteammc.mitrek.util.helper;

import com.bpteammc.mitrek.Mitrek;
import com.bpteammc.mitrek.common.ship.data.ShipData;
import com.bpteammc.mitrek.common.ship.data.ShipSaver;
import com.bpteammc.mitrek.common.tileentity.TileEntityShip;
import com.bpteammc.mitrek.common.world.InteriorGeneration;
import com.bpteammc.mitrek.init.ModDimensions;
import com.bpteammc.mitrek.network.NetworkManager;
import com.bpteammc.mitrek.network.packets.PacketSendShipData;
import com.bpteammc.mitrek.network.packets.PacketShip;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Map;
import java.util.UUID;

import static com.bpteammc.mitrek.common.ship.data.ShipSaver.ships;

public class ShipHelper {
    public static int ship_size = 20;


    public static boolean hasShip(UUID uuid) {
        return false; // TODO needs a system to check , prob with a for loop
    }

    public static BlockPos getFreeShipLocation() {
        if (ships.size() > 0) {
            BlockPos poslast = BlockPos.ORIGIN;
            for (ShipData data : ships.values()) {
                BlockPos pos = data.getInitPos();

                if (pos.getX() > poslast.getX() && pos.getZ() > poslast.getZ())
                    poslast = pos;
            }
            return poslast.add(ship_size * 20, 0, ship_size * 20);
        }
        return new BlockPos(1, 100, 1);
    }

    public static ShipData getShip(int id) {

        if (ships.containsKey(id)) {
            return ships.get(id);
        } else {
            ShipData data = ShipSaver.loadShip(id);
            if (data != null) {
                ships.put(id, data);
                return data;
            } else {
                return ships.get(0);
            }
        }
    }

    public static ShipData getServerData(int shipId, BlockPos pos) {
        ShipData data = getShip(shipId);


        if (data == null) {
            data = new ShipData(0);
        }


        if (data != null) {
            NetworkManager.NETWORK.sendToAll(new PacketSendShipData(data, pos));
        }


        return data;
    }

    public static void makeShip(EntityPlayer player, BlockPos pos, int dim) {
        if (!player.world.isRemote) {
            int lastID = 0;


            for (Map.Entry<Integer, ShipData> list : ships.entrySet()) {
                lastID = list.getKey();
            }

            int shipId = lastID + 1;
            ShipData shipData = new ShipData(shipId);

            shipData.setCurrentPosition(pos);
            shipData.setCurrentDimension(dim);
            BlockPos poso = getFreeShipLocation();
            shipData.setInteriorPosition(poso);
            shipData.setInitPos(poso);

            ShipSaver.addShip(shipId, shipData);

            TileEntityShip ship = (TileEntityShip) player.world.getTileEntity(pos);
            ship.setShipData(shipData);
            ship.setShipID(shipId);

            InteriorGeneration.INTERIOR_LIST.get(0).generate(player.world.getMinecraftServer().getWorld(ModDimensions.MITREKID), poso);
        }
    }

    @Mod.EventBusSubscriber(modid = Mitrek.MODID)
    public static class Events {

        @SubscribeEvent
        public static void sync(LivingEvent.LivingUpdateEvent e) {
            if (e.getEntityLiving().world.getWorldTime() % 200 == 0 && !e.getEntityLiving().world.isRemote && e.getEntityLiving() instanceof EntityPlayer) {
                NetworkManager.NETWORK.sendTo(new PacketShip(), (EntityPlayerMP) e.getEntityLiving());
            }
        }
    }
}
