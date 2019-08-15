package com.bpteammc.mitrek.network;

import com.bpteammc.mitrek.Mitrek;
import com.bpteammc.mitrek.network.packets.PacketShip;
import com.bpteammc.mitrek.network.packets.Warp;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class NetworkManager
{
    public static final SimpleNetworkWrapper NETWORK = NetworkRegistry.INSTANCE.newSimpleChannel(Mitrek.MODID);
    public static int id = -1;

    public static void init() {
        NETWORK.registerMessage(PacketShip.Handler.class, PacketShip.class, id++, Side.CLIENT);
        NETWORK.registerMessage(Warp.Handler.class, Warp.class, 1, Side.CLIENT);
    }
}
