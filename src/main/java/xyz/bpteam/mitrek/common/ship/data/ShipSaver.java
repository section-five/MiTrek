/**
        All code copyright (C) BP Team 2019.
        All rights reserved.
        Contact support@bpteam.xyz for more info
**/
package com.bpteammc.mitrek.common.ship.data;

import com.bpteammc.mitrek.Mitrek;
import net.minecraftforge.fml.relauncher.FMLInjectionData;
import net.minecraftforge.fml.relauncher.Side;

import java.io.*;
import java.util.HashMap;

public class ShipSaver {

    public static HashMap<Integer, ShipData> ships = new HashMap<>();

    public static void addShip(int id, ShipData data) {
        ships.put(id, data);
        updateShipData(data);
    }

    public static void updateShipData(ShipData data) {
        if (data == null && Mitrek.FML.getEffectiveSide() == Side.CLIENT) {
            return;
        }
        String fileDir = ((File) (FMLInjectionData.data()[6])).getAbsolutePath() + "/saves/" + Mitrek.FML.getMinecraftServerInstance().getFolderName() + "/ShipData/";
        String fileName = "Ship_" + data.getShipId() + ".json";
        File dir = new File(fileDir);
        File file = new File(dir + "/" + fileName);

        if (!dir.exists()) {
            dir.mkdirs();
        }


        String json = Mitrek.GSON.toJson(data);

        try {
            if (!file.exists()) file.createNewFile();

            FileWriter fw = new FileWriter(dir + "/" + fileName);
            fw.write(json);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ShipData loadShip(int shipID) {
        if (Mitrek.FML.getEffectiveSide() == Side.CLIENT) {
            return null;
        }

        String fileDir = ((File) (FMLInjectionData.data()[6])).getAbsolutePath() + "/saves/" + Mitrek.FML.getMinecraftServerInstance().getFolderName() + "/ShipData/" + "Ship_" + shipID + ".json";
        if (!new File(fileDir).exists()) {
            return null;
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileDir));

            try {
                return Mitrek.GSON.fromJson(br, ShipData.class);
            } finally {
                br.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ShipData getShip(int id) {
        if (ships.containsKey(id)) {
            return ships.get(id);
        } else {
            ShipData data = loadShip(id);
            if (data != null) {
                ships.put(id, data);
                return data;
            } else {
                return ships.get(0);
            }
        }
    }

    public static void mapAllShips() {
        if (Mitrek.FML.getEffectiveSide() == Side.CLIENT) {
            return;
        }

        String folder = ((File) (FMLInjectionData.data()[6])).getAbsolutePath() + "/saves/" + Mitrek.FML.getMinecraftServerInstance().getFolderName() + "/ShipData/";
        File dir = new File(folder);

        if (!dir.exists()) {
            dir.mkdirs();
        } else {
            for (File file : dir.listFiles()) {
                String name = file.getName();
                File files = new File(dir + "/" + name);
                try {
                    BufferedReader br = new BufferedReader(new FileReader(files));

                    try {
                        ShipData data = Mitrek.GSON.fromJson(br, ShipData.class);
                        ships.put(data.getShipId(), data);
                    } finally {
                        br.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    public static void removeShip(int id) {
        if (Mitrek.FML.getEffectiveSide().isClient()) return;

        if (ships.containsKey(id)) {
            ships.remove(id);
        }
    }



}
