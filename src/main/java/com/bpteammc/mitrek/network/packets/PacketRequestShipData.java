package com.bpteammc.mitrek.network.packets;

import com.bpteammc.mitrek.common.ship.data.ShipData;
import com.bpteammc.mitrek.util.helper.ShipHelper;
import io.netty.buffer.ByteBuf;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketRequestShipData implements IMessage {

   public int ShipId;
   public BlockPos pos;

    public PacketRequestShipData() {
    }

    public PacketRequestShipData(ShipData data, BlockPos pos) {
        this.ShipId = data.getShipId();
        this.pos = pos;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        ShipId = buf.readInt();
        pos = BlockPos.fromLong(buf.readLong());
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(ShipId);
        buf.writeLong(pos.toLong());
    }

    public static class Handler implements IMessageHandler<PacketRequestShipData, IMessage> {

        @Override
        public IMessage onMessage(PacketRequestShipData message, MessageContext ctx) {
            ctx.getServerHandler().player.world.getMinecraftServer().addScheduledTask(new Runnable() {

                @Override
                public void run() {
                    ShipHelper.getServerData(message.ShipId, message.pos);
                }
            });
            return null;
        }
    }
}