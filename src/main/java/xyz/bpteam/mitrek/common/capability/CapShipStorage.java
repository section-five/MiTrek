package xyz.bpteam.mitrek.common.capability;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class CapShipStorage implements Capability.IStorage<IShipCapability> {

    @CapabilityInject(IShipCapability.class)
    public static Capability<CapabilityShip> CAPABILITY = null;

    @Override
    public NBTBase writeNBT(Capability<IShipCapability> capability, IShipCapability instance, EnumFacing side) {
        return instance.serializeNBT();
    }

    @Override
    public void readNBT(Capability<IShipCapability> capability, IShipCapability instance, EnumFacing side, NBTBase nbt) {
        instance.deserializeNBT(nbt instanceof NBTTagCompound ? (NBTTagCompound) nbt : new NBTTagCompound());
    }

    public static class ShipCapProvider implements ICapabilitySerializable<NBTTagCompound> {

        CapabilityShip cap;

        public ShipCapProvider(EntityPlayer player) {
            this.cap = new CapabilityShip(player);
        }

        @Override
        public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
            return capability == CAPABILITY;
        }

        @Override
        public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
            return capability == CAPABILITY ? (T) cap : null;
        }

        @Override
        public NBTTagCompound serializeNBT() {
            return (NBTTagCompound) CapShipStorage.CAPABILITY.getStorage().writeNBT(CapShipStorage.CAPABILITY, cap, null);
        }

        @Override
        public void deserializeNBT(NBTTagCompound nbt) {
            CapShipStorage.CAPABILITY.getStorage().readNBT(CapShipStorage.CAPABILITY, cap, null, nbt);
        }
    }
}
