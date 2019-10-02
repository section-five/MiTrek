/*
        All code copyright (C) BP Team 2019.
        All rights reserved.
        Contact bpteammc@gmail.com for more info
*/
package io.github.bpteammc.mitrek.network.packets;

import io.github.bpteammc.mitrek.util.helper.ShipHelper;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import java.util.HashMap;
import java.util.Map;

public class PacketShip implements IMessage {

    public Map<String, BlockPos> map = new HashMap<String, BlockPos>();

    public PacketShip() {
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        int sizes = buf.readInt();
        for (int i = 0; i < sizes; i++) {
            map.put(ByteBufUtils.readUTF8String(buf), BlockPos.fromLong(buf.readLong()));
        }
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(ShipHelper.ships.size());
        for (String key : ShipHelper.ships.keySet()) {
            ByteBufUtils.writeUTF8String(buf, key);
            buf.writeLong(ShipHelper.ships.get(key).toLong());
        }
    }

    public static class Handler implements IMessageHandler<PacketShip, IMessage> {

        @Override
        public IMessage onMessage(PacketShip message, MessageContext ctx) {
            Minecraft.getMinecraft().addScheduledTask(new Runnable() {
                @Override
                public void run() {
                    ShipHelper.ships.clear();
                    ShipHelper.ships.putAll(message.map);
                }
            });
            return null;
        }
    }
}