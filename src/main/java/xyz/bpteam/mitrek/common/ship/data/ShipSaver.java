/*
        All code copyright (C) BP Team 2019.
        All rights reserved.
        Contact support@bpteam.xyz for more info
*/
package xyz.bpteam.mitrek.common.ship.data;

import xyz.bpteam.mitrek.Mitrek;
import net.minecraftforge.fml.relauncher.FMLInjectionData;
import net.minecraftforge.fml.relauncher.Side;

import java.io.*;
import java.util.HashMap;

public class ShipSaver {

    public static HashMap<Integer, ShipData> ships  = new HashMap<>();

    public static void addShip(int id, ShipData data) {
        ships.put(id, data);
    }

    public static void updateShipData(ShipData data) {
        if (data == null && Mitrek.FML.getEffectiveSide() == Side.CLIENT) {
            return;
        }
        String fileDir = ((File) (FMLInjectionData.data()[6])).getAbsolutePath() + "/saves/" + Mitrek.FML.getMinecraftServerInstance().getFolderName() + "/ShipData/";
        String fileName = "Ship_" + data.getShipId() + ".json";
        File dir = new File(fileDir);

        if (!dir.exists()) {
            dir.mkdirs();
        }
        String json = Mitrek.GSON.toJson(data);

        try {
            FileWriter fw = new FileWriter(dir + "/" + fileName);
            fw.write(json);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ShipData loadShip(int ShipID) {
        if (Mitrek.FML.getEffectiveSide() == Side.CLIENT) {
            return null;
        }
        String fileDir = ((File) (FMLInjectionData.data()[6])).getAbsolutePath() + "/saves/" + Mitrek.FML.getMinecraftServerInstance().getFolderName() + "/ShipData/";
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
        if(ships.containsKey(id)) {
            return ships.get(id);
        }else{
            ShipData data = loadShip(id);
            if(data != null) {
                ships.put(id, data);
                return data;
            }else{
                return ships.get(0);
            }
        }
    }

    public static void removeShip(int id) {
        if(Mitrek.FML.getEffectiveSide().isClient()) return;

        if(ships.containsKey(id)) {
            ships.remove(id);
        }
    }


}
