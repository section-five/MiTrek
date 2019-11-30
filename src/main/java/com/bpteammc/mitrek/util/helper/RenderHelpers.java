/*
        All code copyright (C) BP Team 2019.
        All rights reserved.
        Contact support@bpteammc.com for more info
*/
package com.bpteammc.mitrek.util.helper;

import net.minecraft.util.EnumFacing;

public class RenderHelpers {

    public static float getAngleFromFacing(EnumFacing facing) {
        float angle = 180;
        if (facing.equals(EnumFacing.EAST)) angle = 270;
        if (facing.equals(EnumFacing.SOUTH)) angle = 0;
        if (facing.equals(EnumFacing.WEST)) angle = 90;
        return angle;
    }
}