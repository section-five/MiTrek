/*
        All code copyright (C) BP Team 2019.
        All rights reserved.
        Contact bpteammc@gmail.com for more info
*/
package io.github.bpteammc.mitrek.init;

import io.github.bpteammc.mitrek.common.world.WorldProviderMitrek;
//import io.github.bpteammc.mitrek.common.world.WorldProviderVulcan;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class ModDimensions {

    public static int MITREKID;
    //public static int VULCANID;
    public static DimensionType Type;
    //public static DimensionType vulcanDimensionType;

    public static void Register() {
        MITREKID = DimensionManager.getNextFreeDimId();
        Type = DimensionType.register("mitrek", "_mitrek", MITREKID, WorldProviderMitrek.class, true);
        DimensionManager.registerDimension(MITREKID, Type);
        //VULCANID = DimensionManager.getNextFreeDimId();
        //Type = DimensionType.register("vulcan", "vulcan", VULCANID, WorldProviderVulcan.class, true);
        //DimensionManager.registerDimension(VULCANID, vulcanDimensionType);
    }
}
