/*
 * Copyright 2025 FrozenBlock
 * This file is part of Wilder Wild.
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

package net.frozenblock.wilderwild_japanese_maple.worldgen.impl.sapling;

import java.util.Optional;
import net.frozenblock.wilderwild.WWConstants;
import net.frozenblock.wilderwild_japanese_maple.worldgen.features.configured.WWJMConfigured;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public final class WWJMTreeGrowers {

	public static final TreeGrower JAPANESE_MAPLE = new TreeGrower(
		WWConstants.string("japanese_maple"),
		Optional.empty(),
		Optional.empty(),
		Optional.empty()
	) {
		@Override
		protected @Nullable ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean bees) {
			return bees ? WWJMConfigured.JAPANESE_MAPLES_BEES_SAPLING.getKey() : WWJMConfigured.JAPANESE_MAPLES_NO_BEES.getKey();
		}
	};

	private WWJMTreeGrowers() {
	}
}
