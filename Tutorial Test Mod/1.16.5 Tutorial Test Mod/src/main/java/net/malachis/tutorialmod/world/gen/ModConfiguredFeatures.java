package net.malachis.tutorialmod.world.gen;

import net.malachis.tutorialmod.block.ModBlocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.PlainFlowerBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

public class ModConfiguredFeatures {

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> VOID = register("void", Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.VOID_LOG.get().getDefaultState()), new SimpleBlockStateProvider(ModBlocks.VOID_LEAVES.get().getDefaultState()), new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3), new StraightTrunkPlacer(5, 0, 0), new TwoLayerFeature(0, 0, 0))).setIgnoreVines().build()));

    public static final ConfiguredFeature<?, ?> VOID_FLOWER_CONFIG = Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.VOID_FLOWER.get().getDefaultState()), SimpleBlockPlacer.PLACER)).tries(7).build()).withPlacement((Features.Placements.HEIGHTMAP_PLACEMENT).count(7));

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
    }
}
