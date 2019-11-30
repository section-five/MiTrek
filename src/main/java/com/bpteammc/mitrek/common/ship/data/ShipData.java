/*
        All code copyright (C) BP Team 2019.
        All rights reserved.
        Contact support@bpteammc.com for more info
*/
package com.bpteammc.mitrek.common.ship.data;

import net.minecraft.util.math.BlockPos;

public class ShipData {

    private int shipId;
    private String ownername;
    private String ownerUUID;

    private BlockPos currentPosition;
    private int currentDimension;

    private BlockPos destinationPosition;
    private int destinationDimension;

    private BlockPos interiorPosition;
    private BlockPos initPos;
    private float interiorRotation;


    public ShipData(int shipId) {
        this.shipId = shipId;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public void setOwnerUUID(String ownerUUID) {
        this.ownerUUID = ownerUUID;
    }

    public String getOwnername() {
        return ownername;
    }

    public String getOwnerUUID() {
        return ownerUUID;
    }

    public BlockPos getCurrentPosition() {
        return currentPosition;
    }

    public BlockPos getDestinationPosition() {
        return destinationPosition;
    }

    public int getCurrentDimension() {
        return currentDimension;
    }

    public int getDestinationDimension() {
        return destinationDimension;
    }

    public BlockPos getInteriorPosition() {
        return interiorPosition;
    }

    public float getInteriorRotation() {
        return interiorRotation;
    }

    public void setInteriorPosition(BlockPos interiorPosition) {
        this.interiorPosition = interiorPosition;
    }

    public void setInteriorRotation(float interiorRotation) {
        this.interiorRotation = interiorRotation;
    }

    public void setCurrentDimension(int currentDimension) {
        this.currentDimension = currentDimension;
    }

    public BlockPos getInitPos() {
        return initPos;
    }

    public void setInitPos(BlockPos initPos) {
        this.initPos = initPos;
    }

    public void setCurrentPosition(BlockPos currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void setDestinationDimension(int destinationDimension) {
        this.destinationDimension = destinationDimension;
    }

    public void setDestinationPosition(BlockPos destinationPosition) {
        this.destinationPosition = destinationPosition;
    }

    public void setShipId(int shipId) {
        this.shipId = shipId;
    }

    public int getShipId() {
        return shipId;
    }
}
