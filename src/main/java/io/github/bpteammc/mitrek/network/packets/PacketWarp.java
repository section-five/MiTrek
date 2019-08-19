package io.github.bpteammc.mitrek.network.packets;

import io.github.bpteammc.mitrek.common.tileentity.TileEntityShipExterior;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketWarp implements IMessage {

    public boolean isWarp;
    public BlockPos pos;

    public PacketWarp() {}

    public PacketWarp(BlockPos pos1, boolean b) {
        this.pos = pos1;
        this.isWarp = b;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.pos = BlockPos.fromLong(buf.readLong());
        this.isWarp = buf.readBoolean();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeLong(pos.toLong());
        buf.writeBoolean(isWarp);
    }

    public static class Handler implements IMessageHandler<PacketWarp, IMessage> {

        public Handler() {

        }

        @Override
        public IMessage onMessage(PacketWarp mes, MessageContext ctx) {
            Minecraft.getMinecraft().addScheduledTask(() -> {
                TileEntity te = Minecraft.getMinecraft().world.getTileEntity(mes.pos);
                if (te != null && te instanceof TileEntityShipExterior) {
                    if (mes.isWarp) {
                        ((TileEntityShipExterior) te).setDemat();
                    } else {
                        ((TileEntityShipExterior) te).setRemat();
                    }
                }
            });
            return null;
        }
    }
}


