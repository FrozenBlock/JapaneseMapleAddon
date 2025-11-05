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

package net.frozenblock.wilderwild_japanese_maple.worldgen.modification;

import net.fabricmc.fabric.api.biome.v1.BiomeModificationContext;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.frozenblock.wilderwild_japanese_maple.WWJMConstants;
import net.frozenblock.wilderwild_japanese_maple.tag.WWJMBiomeTags;
import net.frozenblock.wilderwild_japanese_maple.worldgen.features.placed.WWJMPlaced;
import net.minecraft.world.level.levelgen.GenerationStep;

public final class WWJMWorldgen {

	private WWJMWorldgen() {
		throw new UnsupportedOperationException("WWJMWorldgen contains only static declarations.");
	}

	public static void generate() {
		BiomeModifications.create(WWJMConstants.id("japanese_maple_generation"))
			.add(ModificationPhase.ADDITIONS,
				BiomeSelectors.all(),
				(biomeSelectionContext, context) -> {
					final BiomeModificationContext.GenerationSettingsContext generationSettings = context.getGenerationSettings();

					if (biomeSelectionContext.hasTag(WWJMBiomeTags.HAS_JAPANESE_MAPLE)) {
						generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WWJMPlaced.JAPANESE_MAPLE_TREES.getKey());
					}

					if (biomeSelectionContext.hasTag(WWJMBiomeTags.HAS_JAPANESE_MAPLE_SPARSE)) {
						generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WWJMPlaced.JAPANESE_MAPLE_TREES_SPARSE.getKey());
					}

					if (biomeSelectionContext.hasTag(WWJMBiomeTags.HAS_JAPANESE_MAPLE_SHORTER_SPARSE)) {
						generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WWJMPlaced.JAPANESE_MAPLE_TREES_SHORTER_SPARSE.getKey());
					}
			});
	}

}
