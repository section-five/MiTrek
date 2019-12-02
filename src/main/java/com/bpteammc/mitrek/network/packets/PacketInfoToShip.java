package com.bpteammc.mitrek.network.packets;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketInfoToShip implements IMessage {

    public PacketInfoToShip() {
// TODO write from gui to ship
    }

    @Override
    public void fromBytes(ByteBuf buf) {

    }

    @Override
    public void toBytes(ByteBuf buf) {

    }

    public static class Handler implements IMessageHandler<PacketInfoToShip, IMessage> {

        public Handler() {

        }

        @Override
        public IMessage onMessage(PacketInfoToShip message, MessageContext ctx) {
            return null;
        }
    }
}
