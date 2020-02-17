package xyz.bpteam.mitrek.network.packets;

import xyz.bpteam.mitrek.Mitrek;
import xyz.bpteam.mitrek.common.ship.data.ShipData;
import xyz.bpteam.mitrek.common.blocks.BlockShipExterior;
import xyz.bpteam.mitrek.common.tileentity.TileEntityShip;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketSendShipData implements IMessage {

    public ShipData shipdata;
    public BlockPos pos;

    public PacketSendShipData() {
    }

    public PacketSendShipData(ShipData data, BlockPos pos) {
        this.shipdata = data;
        this.pos = pos;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        shipdata = Mitrek.GSON.fromJson(ByteBufUtils.readUTF8String(buf), ShipData.class);
        pos = BlockPos.fromLong(buf.readLong());
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, Mitrek.GSON.toJson(shipdata, ShipData.class));
        buf.writeLong(pos.toLong());
    }

    public static class Handler implements IMessageHandler<PacketSendShipData, IMessage> {

        @Override
        public IMessage onMessage(PacketSendShipData message, MessageContext ctx) {
            EntityPlayer player = Minecraft.getMinecraft().player;
            Minecraft.getMinecraft().addScheduledTask(new Runnable() {
                @Override
                public void run() {
                    ShipData data =  message.shipdata;
                    World world = player.world;

                    if (data.getCurrentPosition() == null) data.setCurrentPosition(BlockPos.ORIGIN);


                    if (world.getBlockState(message.pos).getBlock() instanceof BlockShipExterior)
                        if (world.getTileEntity(message.pos) instanceof TileEntityShip) {
                            TileEntityShip ship = (TileEntityShip) world.getTileEntity(message.pos);
                            ship.setShipData(data);
                        }
                }
            });
            return null;
        }
    }
}