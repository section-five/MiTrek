package com.bpteammc.mitrek.network;

import com.bpteammc.mitrek.Mitrek;
import com.bpteammc.mitrek.network.packets.PacketCapSync;
import com.bpteammc.mitrek.network.packets.PacketRequestShipData;
import com.bpteammc.mitrek.network.packets.PacketSendShipData;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class NetworkManager
{
    public static final SimpleNetworkWrapper NETWORK = NetworkRegistry.INSTANCE.newSimpleChannel(Mitrek.MODID);
    public static int id = -1;

    public static void init() {
        NETWORK.registerMessage(PacketRequestShipData.Handler.class, PacketRequestShipData.class, id++, Side.SERVER);
        NETWORK.registerMessage(PacketSendShipData.Handler.class, PacketSendShipData.class, id++, Side.CLIENT);
        NETWORK.registerMessage(PacketCapSync.Handler.class, PacketCapSync.class, id++, Side.CLIENT);
    }
}
