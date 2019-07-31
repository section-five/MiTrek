package io.github.bpteammc.mitrek.network;

import io.github.bpteammc.mitrek.Mitrek;
import io.github.bpteammc.mitrek.network.packets.PacketShip;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class NetworkManager
{
    public static final SimpleNetworkWrapper NETWORK = NetworkRegistry.INSTANCE.newSimpleChannel(Mitrek.MODID);
    public static int id = -1;

    public static void init() {
        NETWORK.registerMessage(PacketShip.Handler.class, PacketShip.class, id++, Side.CLIENT);
    }
}
