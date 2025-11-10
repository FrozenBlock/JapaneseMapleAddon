/*
 * Copyright 2025 FrozenBlock
 * This file is part of Japanese Maples - Wilder Wild.
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

package net.frozenblock.wilderwild_japanese_maple.worldgen.features.placed;

import net.frozenblock.lib.worldgen.feature.api.FrozenLibPlacedFeature;
import net.frozenblock.wilderwild.worldgen.features.WWPlacementUtils;
import net.frozenblock.wilderwild_japanese_maple.WWJMConstants;
import net.frozenblock.wilderwild_japanese_maple.registry.WWJMBlocks;
import net.frozenblock.wilderwild_japanese_maple.worldgen.features.configured.WWJMConfigured;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import org.jetbrains.annotations.NotNull;
import static net.frozenblock.wilderwild_japanese_maple.worldgen.features.WWJMPlacementUtils.register;
import static net.minecraft.data.worldgen.placement.VegetationPlacements.TREE_THRESHOLD;

public final class WWJMPlaced {
	public static final FrozenLibPlacedFeature JAPANESE_MAPLE_CHECKED = register("japanese_maple_checked");
	public static final FrozenLibPlacedFeature DYING_JAPANESE_MAPLE_CHECKED = register("dying_japanese_maple_checked");
	public static final FrozenLibPlacedFeature TALL_JAPANESE_MAPLE_CHECKED = register("tall_japanese_maple_checked");
	public static final FrozenLibPlacedFeature TALL_DYING_JAPANESE_MAPLE_CHECKED = register("tall_dying_japanese_maple_checked");
	public static final FrozenLibPlacedFeature JAPANESE_MAPLE_BEES_CHECKED = register("japanese_maple_bees_checked");
	public static final FrozenLibPlacedFeature TALL_JAPANESE_MAPLE_BEES_CHECKED = register("tall_japanese_maple_bees_checked");
	public static final FrozenLibPlacedFeature SHORT_JAPANESE_MAPLE_CHECKED = register("short_japanese_maple_checked");
	public static final FrozenLibPlacedFeature FULL_JAPANESE_MAPLE_CHECKED = register("full_japanese_maple_checked");
	public static final FrozenLibPlacedFeature BIG_SHRUB_JAPANESE_MAPLE_CHECKED = register("big_shrub_japanese_maple_checked");

	public static final FrozenLibPlacedFeature JAPANESE_MAPLE_TREES = register("japanese_maple_trees");
	public static final FrozenLibPlacedFeature JAPANESE_MAPLE_TREES_SPARSE = register("japanese_maple_trees_sparse");
	public static final FrozenLibPlacedFeature JAPANESE_MAPLE_TREES_SHORTER_SPARSE = register("japanese_maple_trees_shorter_sparse");

	private WWJMPlaced() {
		throw new UnsupportedOperationException("WWJMPlaced contains only static declarations.");
	}

	public static void registerPlaced(@NotNull BootstrapContext<PlacedFeature> entries) {
		var configuredFeatures = entries.lookup(Registries.CONFIGURED_FEATURE);
		var placedFeatures = entries.lookup(Registries.PLACED_FEATURE);

		WWJMConstants.logWithModId("Registering WWJMPlaced for", true);

		JAPANESE_MAPLE_CHECKED.makeAndSetHolder(WWJMConfigured.JAPANESE_MAPLE_TREE.getHolder(),
			PlacementUtils.filteredByBlockSurvival(WWJMBlocks.JAPANESE_MAPLE_SAPLING)
		);

		DYING_JAPANESE_MAPLE_CHECKED.makeAndSetHolder(WWJMConfigured.DYING_JAPANESE_MAPLE_TREE.getHolder(),
			PlacementUtils.filteredByBlockSurvival(WWJMBlocks.JAPANESE_MAPLE_SAPLING)
		);

		JAPANESE_MAPLE_BEES_CHECKED.makeAndSetHolder(WWJMConfigured.JAPANESE_MAPLE_BEES_0004.getHolder(),
			PlacementUtils.filteredByBlockSurvival(WWJMBlocks.JAPANESE_MAPLE_SAPLING)
		);

		TALL_JAPANESE_MAPLE_CHECKED.makeAndSetHolder(WWJMConfigured.TALL_JAPANESE_MAPLE_TREE.getHolder(),
			PlacementUtils.filteredByBlockSurvival(WWJMBlocks.JAPANESE_MAPLE_SAPLING)
		);

		TALL_DYING_JAPANESE_MAPLE_CHECKED.makeAndSetHolder(WWJMConfigured.TALL_JAPANESE_DYING_MAPLE_TREE.getHolder(),
			PlacementUtils.filteredByBlockSurvival(WWJMBlocks.JAPANESE_MAPLE_SAPLING)
		);

		TALL_JAPANESE_MAPLE_BEES_CHECKED.makeAndSetHolder(WWJMConfigured.TALL_JAPANESE_MAPLE_BEES_0004.getHolder(),
			PlacementUtils.filteredByBlockSurvival(WWJMBlocks.JAPANESE_MAPLE_SAPLING)
		);

		SHORT_JAPANESE_MAPLE_CHECKED.makeAndSetHolder(WWJMConfigured.SHORT_JAPANESE_MAPLE_TREE.getHolder(),
			PlacementUtils.filteredByBlockSurvival(WWJMBlocks.JAPANESE_MAPLE_SAPLING)
		);

		FULL_JAPANESE_MAPLE_CHECKED.makeAndSetHolder(WWJMConfigured.FULL_JAPANESE_MAPLE_TREE.getHolder(),
			PlacementUtils.filteredByBlockSurvival(WWJMBlocks.JAPANESE_MAPLE_SAPLING)
		);

		BIG_SHRUB_JAPANESE_MAPLE_CHECKED.makeAndSetHolder(WWJMConfigured.BIG_SHRUB_JAPANESE_MAPLE.getHolder(),
			PlacementUtils.filteredByBlockSurvival(WWJMBlocks.JAPANESE_MAPLE_SAPLING)
		);

		JAPANESE_MAPLE_TREES.makeAndSetHolder(WWJMConfigured.JAPANESE_MAPLES.getHolder(),
			RarityFilter.onAverageOnceEvery(2),
			InSquarePlacement.spread(),
			TREE_THRESHOLD,
			PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
			PlacementUtils.filteredByBlockSurvival(WWJMBlocks.JAPANESE_MAPLE_SAPLING),
			WWPlacementUtils.TREE_CLEARING_FILTER,
			BiomeFilter.biome()
		);

		JAPANESE_MAPLE_TREES_SPARSE.makeAndSetHolder(WWJMConfigured.JAPANESE_MAPLES.getHolder(),
			RarityFilter.onAverageOnceEvery(16),
			InSquarePlacement.spread(),
			TREE_THRESHOLD,
			PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
			PlacementUtils.filteredByBlockSurvival(WWJMBlocks.JAPANESE_MAPLE_SAPLING),
			WWPlacementUtils.TREE_CLEARING_FILTER,
			BiomeFilter.biome()
		);

		JAPANESE_MAPLE_TREES_SHORTER_SPARSE.makeAndSetHolder(WWJMConfigured.JAPANESE_MAPLES_SHORTER.getHolder(),
			RarityFilter.onAverageOnceEvery(16),
			InSquarePlacement.spread(),
			TREE_THRESHOLD,
			PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
			PlacementUtils.filteredByBlockSurvival(WWJMBlocks.JAPANESE_MAPLE_SAPLING),
			WWPlacementUtils.TREE_CLEARING_FILTER,
			BiomeFilter.biome()
		);
	}

}
