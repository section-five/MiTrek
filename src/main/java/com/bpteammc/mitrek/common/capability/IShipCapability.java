package com.bpteammc.mitrek.common.capability;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;


public interface IShipCapability extends INBTSerializable<NBTTagCompound> {

    void update();

    void sync();

    void setShipId(int id);

    int getShipId();
}
