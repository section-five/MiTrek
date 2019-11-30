/*
        All code copyright (C) BP Team 2019.
        All rights reserved.
        Contact support@bpteammc.com for more info
*/
package com.bpteammc.mitrek.common.entity;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

public class EntityBeam extends EntityThrowable implements IEntityAdditionalSpawnData {

    public float damage;
    private DamageSource source;
    public Vec3d color;


    public EntityBeam(World worldIn, EntityLivingBase throwerIn, float damage, DamageSource source, Vec3d color) {
        super(worldIn, throwerIn);
        this.damage = damage;
        this.color = color;
        this.source = source;
    }

    @Override
    protected void onImpact(RayTraceResult result) {

        if (result == null || isDead || world.isRemote)
            return;

        if (result.typeOfHit == RayTraceResult.Type.ENTITY) {
            if (result.entityHit == this.thrower) return;
            Entity entity = result.entityHit;

            if (result.entityHit instanceof EntityPlayer) {
                if (!((EntityPlayer) result.entityHit).capabilities.isCreativeMode) {
                }
            } else {
                if (result.entityHit instanceof EntityLiving) {
                    if (result.entityHit.getIsInvulnerable()) return;

                    if (!(result.entityHit instanceof EntityHanging)) {
                        if (result.entityHit instanceof EntityEnderman || result.entityHit instanceof EntityDragon) {
                            result.entityHit.setDead();
                        }
                    }
                }
            }
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, getThrower()), damage);

        } else if (result.typeOfHit == RayTraceResult.Type.BLOCK) {
            this.setDead();
        }

        if (!this.world.isRemote)
            this.setDead();
    }


    @Override
    protected float getGravityVelocity() {
        return 0.00000F;
    }


    @Override
    public void writeSpawnData(ByteBuf buffer) {
        NBTTagCompound nbt = new NBTTagCompound();
        this.writeEntityToNBT(nbt);
        ByteBufUtils.writeTag(buffer, nbt);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setFloat("Damage", damage);
        compound.setDouble("Color_R", color.x);
        compound.setDouble("Color_G", color.y);
        compound.setDouble("Color_B", color.z);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        this.damage = compound.getFloat("Damage");
        this.color = new Vec3d(compound.getDouble("Color_R"), compound.getDouble("Color_G"), compound.getDouble("Color_B"));
    }

    @Override
    public void readSpawnData(ByteBuf additionalData) {
        this.readEntityFromNBT(ByteBufUtils.readTag(additionalData));
    }

    @Override
    public void onEntityUpdate() {
        double movingspeed = new Vec3d(posX, posY, posZ).distanceTo(new Vec3d(prevPosX, prevPosY, prevPosZ));
        if (this.ticksExisted == 400 || movingspeed < 0.01) {
            this.setDead();
        }
    }
}
