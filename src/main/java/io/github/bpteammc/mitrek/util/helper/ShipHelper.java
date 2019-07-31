package io.github.bpteammc.mitrek.util.helper;

import io.github.bpteammc.mitrek.Mitrek;
import io.github.bpteammc.mitrek.common.tileentity.TileEntityShip;
import io.github.bpteammc.mitrek.common.world.InteriorGeneration;
import io.github.bpteammc.mitrek.init.ModBlocks;
import io.github.bpteammc.mitrek.init.ModDimensions;
import io.github.bpteammc.mitrek.network.NetworkManager;
import io.github.bpteammc.mitrek.network.packets.PacketShip;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ShipHelper {
    public static int ship_size = 20;

    public static Map<String, BlockPos> ships = new HashMap<>();

    public static boolean hasShip(UUID uuid) {
        return ships.containsKey(uuid.toString());
    }

    public static BlockPos addShip(UUID uuid) {
        if (!hasShip(uuid))
            ships.put(uuid.toString(), getFreeShipLocation().toImmutable());
        return getFreeShipLocation();
    }

    public static BlockPos getFreeShipLocation() {
        if (ships.size() > 0) {
            BlockPos poslast = BlockPos.ORIGIN;
            for (BlockPos pos : ships.values().toArray(new BlockPos[]{})) {
                if (pos.getX() > poslast.getX() && pos.getZ() > poslast.getZ())
                    poslast = pos;
            }
            return poslast.add(ship_size * 20, 0, ship_size * 20);
        }
        return new BlockPos(1, 100, 1);
    }

    public static BlockPos getTardis(Vec3i vec3i) {
        for (BlockPos pos : ships.values()) {
            if (pos.getDistance(vec3i.getX(), vec3i.getY(), vec3i.getZ()) < (ship_size * ship_size) / 2) {
                return pos;
            }
        }
        return BlockPos.ORIGIN;
    }

    public static void makeShip(EntityPlayer player, BlockPos pos) {
        if (!player.world.isRemote) {
            BlockPos position = addShip(player.getUniqueID());
            WorldServer worldServer = player.world.getMinecraftServer().getWorld(ModDimensions.MITREKID);
            if (position != null && worldServer != null) {
                TileEntity te = worldServer.getTileEntity(position);
                if (te == null || !(te instanceof TileEntityShip)) {
                    InteriorGeneration.INTERIOR_LIST.get(0).generate((player.world).getMinecraftServer().getWorld(ModDimensions.MITREKID), position);
                    worldServer.setBlockState(position, ModBlocks.SHIP_CONSOLE.getDefaultState()); // TODO Get Sub Blocks
                    TileEntityShip ship = (TileEntityShip) worldServer.getTileEntity(position);
                    ship.setDestination(pos, player.world.provider.getDimension());
                    ship.setIsinFlight(true);
                    ship.spawnFirst();
                }
            }
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
