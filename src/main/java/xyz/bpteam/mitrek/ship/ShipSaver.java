package xyz.bpteam.mitrek.ship;

import java.util.HashMap;
import java.util.UUID;

public class ShipSaver {

    public static HashMap<UUID, ShipData> ship = new HashMap<>();

    public static void createShip(UUID uuid, ShipData data){
        ship.put(uuid, data);
    }

    public static void updateMap(ShipData data){

    }
}
