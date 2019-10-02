/*
        All code copyright (C) BP Team 2019.
        All rights reserved.
        Contact bpteammc@gmail.com for more info
*/
package io.github.bpteammc.mitrek.network;

import io.github.bpteammc.mitrek.Mitrek;
import io.github.bpteammc.mitrek.network.packets.PacketInfoToShip;
import io.github.bpteammc.mitrek.network.packets.PacketShip;
import io.github.bpteammc.mitrek.network.packets.PacketWarp;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class NetworkManager
{
    public static final SimpleNetworkWrapper NETWORK = NetworkRegistry.INSTANCE.newSimpleChannel(Mitrek.MODID);
    public static int id = -1;

    public static void init() {
        NETWORK.registerMessage(PacketShip.Handler.class, PacketShip.class, id++, Side.CLIENT);
        NETWORK.registerMessage(PacketWarp.Handler.class, PacketWarp.class, id++, Side.CLIENT);
        NETWORK.registerMessage(PacketInfoToShip.Handler.class, PacketInfoToShip.class, id++, Side.CLIENT);
    }
}
