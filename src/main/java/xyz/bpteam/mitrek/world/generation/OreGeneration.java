package xyz.bpteam.mitrek.world.generation;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;
import xyz.bpteam.mitrek.init.ModBlocks;

public class OreGeneration {
    public static void init() {
        for (Biome biome : ForgeRegistries.BIOMES) {
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.COPPER_ORE.getDefaultState(), 9)).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(15, 0, 0, 75))));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.DURANIUM_ORE.getDefaultState(), 9)).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(5, 0, 0, 16))));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.MAGNESITE_ORE.getDefaultState(), 9)).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(16, 0, 0, 32))));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.TRITANIUM_ORE.getDefaultState(), 9)).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(5, 0, 0, 20))));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.VICTURIUM_ORE.getDefaultState(), 9)).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(8, 0, 0, 25))));
        }
    }
}
