/*package xyz.bpteam.mitrek.ship;

import net.minecraft.world.storage.IPlayerFileData;
import xyz.bpteam.mitrek.MiTrek;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class ShipSaver {

    public static HashMap<Integer, ShipData> ship = new HashMap<>();

    public static void createShip(Integer id, ShipData data) {
        ship.put(id, data);
    }

    public static void saveShip(ShipData data) {
        if (doesShipExist(data.getShipID())) {
            ShipData info = data.getShip();
            String file = ((File));
            String fileName = "ship_" + data.getShipID() + ".json";
            File dir = new File(file);

            if (!dir.exists()) {
                dir.mkdirs();
            }

            String json = MiTrek.GSON.toJson(data);

            try {
                FileWriter fw = new FileWriter(dir + "/" + fileName);
                fw.write(json);
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}*/