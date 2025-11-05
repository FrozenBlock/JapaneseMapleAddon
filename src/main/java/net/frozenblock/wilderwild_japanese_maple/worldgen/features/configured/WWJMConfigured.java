/*
 * Copyright 2025 FrozenBlock
 * This file is part of Wilder Aquatic.
 *
 * This program is free software; you can modify it under
 * the terms of version 1 of the FrozenBlock Modding Oasis License
 * as published by FrozenBlock Modding Oasis.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * FrozenBlock Modding Oasis License for more details.
 *
 * You should have received a copy of the FrozenBlock Modding Oasis License
 * along with this program; if not, see <https://github.com/FrozenBlock/Licenses>.
 */

package net.frozenblock.wilderwild_japanese_maple.worldgen.features.configured;

import net.frozenblock.lib.worldgen.feature.api.FrozenLibConfiguredFeature;
import net.frozenblock.lib.worldgen.feature.api.FrozenLibFeatures;
import net.frozenblock.lib.worldgen.feature.api.feature.config.ComboFeatureConfig;
import net.frozenblock.lib.worldgen.feature.api.feature.disk.config.BallBlockPlacement;
import net.frozenblock.lib.worldgen.feature.api.feature.disk.config.BallFeatureConfig;
import net.frozenblock.lib.worldgen.feature.api.feature.disk.config.BallOuterRingBlockPlacement;
import net.frozenblock.wilderwild.worldgen.features.WWFeatureUtils;
import net.frozenblock.wilderwild.worldgen.features.configured.WWMiscConfigured;
import net.frozenblock.wilderwild.worldgen.features.configured.WWTreeConfigured;
import net.frozenblock.wilderwild_japanese_maple.WWJMConstants;
import net.frozenblock.wilderwild.registry.WWBlocks;
import net.frozenblock.wilderwild_japanese_maple.registry.WWJMBlocks;
import net.frozenblock.wilderwild_japanese_maple.worldgen.features.placed.WWJMPlaced;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BushFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import org.jetbrains.annotations.NotNull;
import java.util.List;
import java.util.Optional;
import static net.frozenblock.wilderwild_japanese_maple.worldgen.features.WWJMFeatureUtils.register;

public final class WWJMConfigured {
	public static final FrozenLibConfiguredFeature<TreeConfiguration> JAPANESE_MAPLE_TREE = register("japanese_maple");
	public static final FrozenLibConfiguredFeature<TreeConfiguration> DYING_JAPANESE_MAPLE_TREE = register("dying_japanese_maple");
	public static final FrozenLibConfiguredFeature<TreeConfiguration> TALL_JAPANESE_MAPLE_TREE = register("tall_japanese_maple");
	public static final FrozenLibConfiguredFeature<TreeConfiguration> TALL_JAPANESE_DYING_MAPLE_TREE = register("tall_dying_japanese_maple");
	public static final FrozenLibConfiguredFeature<TreeConfiguration> JAPANESE_MAPLE_BEES_0004 = register("japanese_maple_bees_025");
	public static final FrozenLibConfiguredFeature<TreeConfiguration> TALL_JAPANESE_MAPLE_BEES_0004 = register("tall_japanese_maple_bees_025");
	public static final FrozenLibConfiguredFeature<TreeConfiguration> SHORT_JAPANESE_MAPLE_TREE = register("short_japanese_maple");
	public static final FrozenLibConfiguredFeature<TreeConfiguration> FULL_JAPANESE_MAPLE_TREE = register("full_japanese_maple");
	public static final FrozenLibConfiguredFeature<TreeConfiguration> BIG_SHRUB_JAPANESE_MAPLE = register("big_shrub_japanese_maple");

	public static final FrozenLibConfiguredFeature<BallFeatureConfig> JAPANESE_MAPLE_LEAF_LITTER = register("japanese_maple_leaf_litter");

	public static final FrozenLibConfiguredFeature<ComboFeatureConfig> JAPANESE_MAPLES = register("japanese_maples");
	public static final FrozenLibConfiguredFeature<ComboFeatureConfig> JAPANESE_MAPLES_SHORTER = register("japanese_maples_shorter");
	public static final FrozenLibConfiguredFeature<RandomFeatureConfiguration> JAPANESE_MAPLES_NO_BEES = register("japanese_maples_no_bees");
	public static final FrozenLibConfiguredFeature<RandomFeatureConfiguration> JAPANESE_MAPLES_BEES_SAPLING = register("japanese_maples_bees_sapling");

	private WWJMConfigured() {
		throw new UnsupportedOperationException("WWJMConfigured contains only static declarations.");
	}

	public static void registerConfigured(@NotNull BootstrapContext<ConfiguredFeature<?, ?>> entries) {
		var configuredFeatures = entries.lookup(Registries.CONFIGURED_FEATURE);
		var placedFeatures = entries.lookup(Registries.PLACED_FEATURE);

		WWJMConstants.logWithModId("Registering WWJMConfigured for", true);

		JAPANESE_MAPLE_TREE.makeAndSetHolder(Feature.TREE,
			japaneseMaple().decorators(
				List.of(WWTreeConfigured.SHELF_FUNGUS_0074)
			).dirt(BlockStateProvider.simple(Blocks.DIRT)).build()
		);

		DYING_JAPANESE_MAPLE_TREE.makeAndSetHolder(Feature.TREE,
			japaneseMaple().decorators(
				List.of(
					WWTreeConfigured.SHELF_FUNGUS_0074,
					WWTreeConfigured.VINES_1_UNDER_260_03
				)
			).dirt(BlockStateProvider.simple(Blocks.DIRT)).build()
		);

		TALL_JAPANESE_MAPLE_TREE.makeAndSetHolder(Feature.TREE,
			tallJapaneseMaple().decorators(
				List.of(WWTreeConfigured.SHELF_FUNGUS_0074)
			).dirt(BlockStateProvider.simple(Blocks.DIRT)).build()
		);

		TALL_JAPANESE_DYING_MAPLE_TREE.makeAndSetHolder(Feature.TREE,
			tallJapaneseMaple().decorators(
				List.of(
					WWTreeConfigured.SHELF_FUNGUS_0074,
					WWTreeConfigured.VINES_1_UNDER_260_03
				)
			).dirt(BlockStateProvider.simple(Blocks.DIRT)).build()
		);

		JAPANESE_MAPLE_BEES_0004.makeAndSetHolder(Feature.TREE,
			japaneseMaple().decorators(
				List.of(
					WWTreeConfigured.BEES_0004,
					WWTreeConfigured.POLLEN_01,
					WWTreeConfigured.SHELF_FUNGUS_0074
				)
			).dirt(BlockStateProvider.simple(Blocks.DIRT)).build()
		);

		TALL_JAPANESE_MAPLE_BEES_0004.makeAndSetHolder(Feature.TREE,
			tallJapaneseMaple().decorators(
				List.of(
					WWTreeConfigured.BEES_0004,
					WWTreeConfigured.POLLEN_01,
					WWTreeConfigured.SHELF_FUNGUS_0074
				)
			).dirt(BlockStateProvider.simple(Blocks.DIRT)).build()
		);

		SHORT_JAPANESE_MAPLE_TREE.makeAndSetHolder(Feature.TREE,
			shortJapaneseMaple().decorators(
				List.of(WWTreeConfigured.SHELF_FUNGUS_0074)
			).dirt(BlockStateProvider.simple(Blocks.DIRT)).build()
		);

		FULL_JAPANESE_MAPLE_TREE.makeAndSetHolder(Feature.TREE,
			fullJapaneseMaple().decorators(
				List.of(WWTreeConfigured.SHELF_FUNGUS_0074)
			).dirt(BlockStateProvider.simple(Blocks.DIRT)).build()
		);

		BIG_SHRUB_JAPANESE_MAPLE.makeAndSetHolder(Feature.TREE,
			new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(WWBlocks.MAPLE_LOG),
				new StraightTrunkPlacer(1, 0, 0),
				BlockStateProvider.simple(WWJMBlocks.JAPANESE_MAPLE_LEAVES),
				new BushFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 2),
				new TwoLayersFeatureSize(0, 0, 0)
			).dirt(BlockStateProvider.simple(Blocks.DIRT)).build()
		);

		JAPANESE_MAPLE_LEAF_LITTER.makeAndSetHolder(FrozenLibFeatures.BALL_FEATURE,
			new BallFeatureConfig(
				new BallBlockPlacement.Builder(BlockStateProvider.simple(WWJMBlocks.JAPANESE_MAPLE_LEAF_LITTER))
					.placementChance(0.75F)
					.fadeStartPercentage(0.5F)
					.searchingBlockPredicate(BlockPredicate.wouldSurvive(WWJMBlocks.JAPANESE_MAPLE_LEAF_LITTER.defaultBlockState(), Vec3i.ZERO))
					.verticalPlacementOffset(1)
					.outerRingBlockPlacement(
						new BallOuterRingBlockPlacement.Builder(BlockStateProvider.simple(WWJMBlocks.JAPANESE_MAPLE_LEAF_LITTER))
							.placementChance(0.65F)
							.outerRingStartPercentage(0.7F)
							.searchingBlockPredicate(BlockPredicate.wouldSurvive(WWJMBlocks.JAPANESE_MAPLE_LEAF_LITTER.defaultBlockState(), Vec3i.ZERO))
							.verticalPlacementOffset(1)
							.build()
					).build(),
				Optional.of(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES),
				UniformInt.of(2, 4)
			)
		);

		JAPANESE_MAPLES.makeAndSetHolder(
			FrozenLibFeatures.COMBO_FEATURE,
			new ComboFeatureConfig(
				List.of(
					PlacementUtils.inlinePlaced(
						Feature.RANDOM_SELECTOR,
						new RandomFeatureConfiguration(
							List.of(
								new WeightedPlacedFeature(WWJMPlaced.JAPANESE_MAPLE_CHECKED.getHolder(), 0.025F),
								new WeightedPlacedFeature(WWJMPlaced.FULL_JAPANESE_MAPLE_CHECKED.getHolder(), 0.15F),
								new WeightedPlacedFeature(WWJMPlaced.TALL_JAPANESE_MAPLE_CHECKED.getHolder(), 0.25F),
								new WeightedPlacedFeature(WWJMPlaced.DYING_JAPANESE_MAPLE_CHECKED.getHolder(), 0.0785F),
								new WeightedPlacedFeature(WWJMPlaced.TALL_JAPANESE_MAPLE_BEES_CHECKED.getHolder(), 0.37F),
								new WeightedPlacedFeature(WWJMPlaced.TALL_DYING_JAPANESE_MAPLE_CHECKED.getHolder(), 0.0785F),
								new WeightedPlacedFeature(WWJMPlaced.JAPANESE_MAPLE_BEES_CHECKED.getHolder(), 0.37F),
								new WeightedPlacedFeature(WWJMPlaced.SHORT_JAPANESE_MAPLE_CHECKED.getHolder(), 0.2F),
								new WeightedPlacedFeature(WWJMPlaced.BIG_SHRUB_JAPANESE_MAPLE_CHECKED.getHolder(), 0.4F)
							),
							WWJMPlaced.JAPANESE_MAPLE_BEES_CHECKED.getHolder()
						)
					),
					PlacementUtils.inlinePlaced(JAPANESE_MAPLE_LEAF_LITTER.getHolder())
				)
			)
		);

		JAPANESE_MAPLES_SHORTER.makeAndSetHolder(
			FrozenLibFeatures.COMBO_FEATURE,
			new ComboFeatureConfig(
				List.of(
					PlacementUtils.inlinePlaced(
						Feature.RANDOM_SELECTOR,
						new RandomFeatureConfiguration(
							List.of(
								new WeightedPlacedFeature(WWJMPlaced.JAPANESE_MAPLE_CHECKED.getHolder(), 0.025F),
								new WeightedPlacedFeature(WWJMPlaced.FULL_JAPANESE_MAPLE_CHECKED.getHolder(), 0.30F),
								new WeightedPlacedFeature(WWJMPlaced.DYING_JAPANESE_MAPLE_CHECKED.getHolder(), 0.3785F),
								new WeightedPlacedFeature(WWJMPlaced.JAPANESE_MAPLE_BEES_CHECKED.getHolder(), 0.37F),
								new WeightedPlacedFeature(WWJMPlaced.SHORT_JAPANESE_MAPLE_CHECKED.getHolder(), 0.45F),
								new WeightedPlacedFeature(WWJMPlaced.BIG_SHRUB_JAPANESE_MAPLE_CHECKED.getHolder(), 0.3F)
							),
							WWJMPlaced.JAPANESE_MAPLE_BEES_CHECKED.getHolder()
						)
					),
					PlacementUtils.inlinePlaced(JAPANESE_MAPLE_LEAF_LITTER.getHolder())
				)
			)
		);

		JAPANESE_MAPLES_BEES_SAPLING.makeAndSetHolder(Feature.RANDOM_SELECTOR,
			new RandomFeatureConfiguration(
				List.of(
					new WeightedPlacedFeature(WWJMPlaced.JAPANESE_MAPLE_CHECKED.getHolder(), 0.025F),
					new WeightedPlacedFeature(WWJMPlaced.FULL_JAPANESE_MAPLE_CHECKED.getHolder(), 0.15F),
					new WeightedPlacedFeature(WWJMPlaced.TALL_JAPANESE_MAPLE_CHECKED.getHolder(), 0.25F),
					new WeightedPlacedFeature(WWJMPlaced.DYING_JAPANESE_MAPLE_CHECKED.getHolder(), 0.0785F),
					new WeightedPlacedFeature(WWJMPlaced.TALL_JAPANESE_MAPLE_BEES_CHECKED.getHolder(), 0.37F),
					new WeightedPlacedFeature(WWJMPlaced.TALL_DYING_JAPANESE_MAPLE_CHECKED.getHolder(), 0.0785F),
					new WeightedPlacedFeature(WWJMPlaced.SHORT_JAPANESE_MAPLE_CHECKED.getHolder(), 0.2F),
					new WeightedPlacedFeature(WWJMPlaced.BIG_SHRUB_JAPANESE_MAPLE_CHECKED.getHolder(), 0.4F)
				),
				WWJMPlaced.JAPANESE_MAPLE_BEES_CHECKED.getHolder()
			)
		);

		JAPANESE_MAPLES_NO_BEES.makeAndSetHolder(Feature.RANDOM_SELECTOR,
			new RandomFeatureConfiguration(
				List.of(
					new WeightedPlacedFeature(WWJMPlaced.JAPANESE_MAPLE_CHECKED.getHolder(), 0.025F),
					new WeightedPlacedFeature(WWJMPlaced.FULL_JAPANESE_MAPLE_CHECKED.getHolder(), 0.15F),
					new WeightedPlacedFeature(WWJMPlaced.TALL_JAPANESE_MAPLE_CHECKED.getHolder(), 0.25F),
					new WeightedPlacedFeature(WWJMPlaced.DYING_JAPANESE_MAPLE_CHECKED.getHolder(), 0.0785F),
					new WeightedPlacedFeature(WWJMPlaced.TALL_DYING_JAPANESE_MAPLE_CHECKED.getHolder(), 0.0785F),
					new WeightedPlacedFeature(WWJMPlaced.SHORT_JAPANESE_MAPLE_CHECKED.getHolder(), 0.2F),
					new WeightedPlacedFeature(WWJMPlaced.BIG_SHRUB_JAPANESE_MAPLE_CHECKED.getHolder(), 0.4F)
				),
				WWJMPlaced.JAPANESE_MAPLE_CHECKED.getHolder()
			)
		);
	}

	@NotNull
	public static TreeConfiguration.TreeConfigurationBuilder japaneseMaple() {
		return WWTreeConfigured.maple(WWJMBlocks.JAPANESE_MAPLE_LEAVES);
	}

	@NotNull
	public static TreeConfiguration.TreeConfigurationBuilder tallJapaneseMaple() {
		return WWTreeConfigured.tallMaple(WWJMBlocks.JAPANESE_MAPLE_LEAVES);
	}

	@NotNull
	public static TreeConfiguration.TreeConfigurationBuilder shortJapaneseMaple() {
		return WWTreeConfigured.shortMaple(WWJMBlocks.JAPANESE_MAPLE_LEAVES);
	}

	@NotNull
	public static TreeConfiguration.TreeConfigurationBuilder fullJapaneseMaple() {
		return WWTreeConfigured.fullMaple(WWJMBlocks.JAPANESE_MAPLE_LEAVES);
	}
}
