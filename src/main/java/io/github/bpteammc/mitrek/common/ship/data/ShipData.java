/*
        All code copyright (C) BP Team 2019.
        All rights reserved.
        Contact bpteammc@gmail.com for more info
*/
package io.github.bpteammc.mitrek.common.ship.data;

public class ShipData {

    private int shipId;
    private String ownername;
    private String ownerUUID;


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

    public int getShipId() {
        return shipId;
    }
}
