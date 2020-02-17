package xyz.bpteam.mitrek.network.packets;

import xyz.bpteam.mitrek.Mitrek;
import xyz.bpteam.mitrek.common.ship.data.ShipData;
import xyz.bpteam.mitrek.common.ship.data.ShipSaver;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import java.util.HashMap;
import java.util.Map;

public class PacketShip implements IMessage {

    public Map<Integer, ShipData> map = new HashMap<>();

    public PacketShip() {
    }

    public PacketShip(Map<Integer, ShipData> map) {
        this.map = map;
    }


    @Override
    public void fromBytes(ByteBuf buf) {
        int sizes = buf.readInt();
        for (int i = 0; i < sizes; i++) {
            int id = buf.readInt();
            ShipData data = Mitrek.GSON.fromJson(ByteBufUtils.readUTF8String(buf), ShipData.class);
            map.put(id, data);
        }
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(ShipSaver.ships.size());
        for (Map.Entry<Integer, ShipData> map : ShipSaver.ships.entrySet()) {
            buf.writeInt(map.getKey());
            ByteBufUtils.writeUTF8String(buf, Mitrek.GSON.toJson(map.getValue()));
        }
    }

    public static class Handler implements IMessageHandler<PacketShip, IMessage> {

        @Override
        public IMessage onMessage(PacketShip message, MessageContext ctx) {
            Minecraft.getMinecraft().addScheduledTask(new Runnable() {
                @Override
                public void run() {
                    ShipSaver.ships.clear();
                    ShipSaver.ships.putAll(message.map);
                }
            });
            return null;
        }
    }
}