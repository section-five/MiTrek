/*
        All code copyright (C) BP Team 2019.
        All rights reserved.
        Contact support@bpteammc.com for more info
*/
package com.bpteammc.mitrek.util.helper;

import com.bpteammc.mitrek.common.damage.IDamageSource;
import com.bpteammc.mitrek.common.entity.EntityBeam;
import com.bpteammc.mitrek.init.ModItems;
import com.bpteammc.mitrek.util.handlers.SoundsHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ShootWeapon {

    public static void Beam(EntityPlayer entityplayer, World worldIn, ItemStack stack) {
        if (worldIn.isRemote && !entityplayer.isSneaking() && entityplayer.getHeldItemOffhand().getItem() != ModItems.TOS_PHASER) {
            entityplayer.playSound(SoundsHandler.TOS_SHOOT, 1, 1);
        }
        ShootWeapon.ShootBeam(entityplayer, worldIn, 100, 1, 0, 5);
    }

    public static void ShootBeam(EntityPlayer entityplayer, World worldIn, int damage, int r, int g, int b) {
        Vec3d v3 = entityplayer.getLook(1);
        EntityBeam beam = new EntityBeam(worldIn, entityplayer, damage, IDamageSource.BEAM, new Vec3d(r, g, b));
        beam.shoot(v3.x, v3.y, v3.z, 1.5F, (float) 0);
        worldIn.spawnEntity(beam);
    }
}