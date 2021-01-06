package me.ukminecrafted.mitrek.world.generation;

import me.ukminecrafted.mitrek.MiTrek;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.*;

import net.minecraft.world.gen.placement.DepthAverageConfig;
import net.minecraft.world.gen.placement.Placement;

import me.ukminecrafted.mitrek.init.ModBlocks;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;

public class OreGeneration {

    public static final DeferredRegister<?> OREGEN = DeferredRegister.create(ForgeRegistries.FEATURES, MiTrek.MODID);

    public static final RegistryObject<Feature<OreFeatureConfig>> COPPER_ORE = OREGEN.register("copper_ore", () ->  new OreFeature(OreFeatureConfig.CODEC));

    public static class ConfiguredFeatures {

        public static final ConfiguredFeature<?, ?> COPPER_ORE_CONFIGURED = OreGeneration.COPPER_ORE.get().withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.COPPER_ORE.getDefaultState(), 5))
                .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(6,0,64))).square().func_242731_b(5);

    }

    private static <T extends Feature<?>> void registerConfiguredFeature(String registryName, ConfiguredFeature<?,?> configuredFeature) {
        Registry<ConfiguredFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_FEATURE;
        Registry.register(registry, new ResourceLocation(MiTrek.MODID, registryName), configuredFeature);

    }


    /*public static void init() {
        for (Biome biome : BiomeLoadingEvent) {
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.COPPER_ORE.getDefaultState(), 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(15, 0, 0, 75))));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.DURANIUM_ORE.getDefaultState(), 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(5, 0, 0, 16))));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.MAGNESITE_ORE.getDefaultState(), 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(16, 0, 0, 32))));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.TRITANIUM_ORE.getDefaultState(), 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(5, 0, 0, 20))));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.VICTURIUM_ORE.getDefaultState(), 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 0, 0, 25))));

        }
    }*/