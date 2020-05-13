package xyz.bpteam.mitrek.world.dim;

import net.minecraft.client.audio.MusicTicker;
import net.minecraft.client.gui.screen.DeathScreen;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class ShipDimension extends Dimension {
    public ShipDimension(World p_i225788_1_, DimensionType p_i225788_2_, float p_i225788_3_) {
        super(p_i225788_1_, p_i225788_2_, p_i225788_3_);
    }

    @Override
    public ChunkGenerator<?> createChunkGenerator() {
        return null;
    }

    @Nullable
    @Override
    public BlockPos findSpawn(ChunkPos chunkPosIn, boolean checkValid) {
        return null;
    }

    @Nullable
    @Override
    public BlockPos findSpawn(int posX, int posZ, boolean checkValid) {
        return null;
    }

    @Override
    public float calculateCelestialAngle(long worldTime, float partialTicks) {
        return 0;
    }


    @Override
    public boolean isSurfaceWorld() {
        return false;
    }

    @Override
    public Vec3d getFogColor(float celestialAngle, float partialTicks) {
        return null;
    }


    @Override
    public boolean canRespawnHere() {
        return true;
    }

    @Override
    public boolean doesXZShowFog(int x, int z) {
        return false;
    }

    @Override
    public Dimension getDimension() {
        return null;
    }

    @Override
    public ICapabilityProvider initCapabilities() {
        return null;
    }

    @Override
    public double getMovementFactor() {
        return 0;
    }

    @Override
    public void getLightmapColors(float partialTicks, float sunBrightness, float skyLight, float blockLight, Vector3f colors) {

    }

    @Override
    public boolean canDoLightning(Chunk chunk) {
        return false;
    }

    @Override
    public boolean canDoRainSnowIce(Chunk chunk) {
        return false;
    }

    @Override
    public SleepResult canSleepAt(PlayerEntity player, BlockPos pos) {
        return SleepResult.ALLOW;
    }

    @Override
    public boolean isDaytime() {
        return false;
    }

    @Override
    public float getCurrentMoonPhaseFactor(long time) {
        return 0;
    }

    @Override
    public void setAllowedSpawnTypes(boolean allowHostile, boolean allowPeaceful) {
    }


    @Override
    public long getSeed() {
        return 0;
    }

    @Override
    public long getWorldTime() {
        return 0;
    }

    @Override
    public void setWorldTime(long time) {

    }

    @Override
    public BlockPos getSpawnPoint() {
        return null;
    }

    @Override
    public void setSpawnPoint(BlockPos pos) {

    }

    @Override
    public boolean canMineBlock(PlayerEntity player, BlockPos pos) {
        return false;
    }

    @Override
    public boolean isHighHumidity(BlockPos pos) {
        return false;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getActualHeight() {
        return 0;
    }

    @Override
    public int getSeaLevel() {
        return 0;
    }

    @Override
    public boolean shouldMapSpin(String entity, double x, double z, double rotation) {
        return false;
    }

    @Override
    public DimensionType getRespawnDimension(ServerPlayerEntity player) {
        return null;
    }
}