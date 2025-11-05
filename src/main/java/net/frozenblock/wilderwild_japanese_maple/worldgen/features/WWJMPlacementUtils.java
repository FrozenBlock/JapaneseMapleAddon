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

package net.frozenblock.wilderwild_japanese_maple.worldgen.features;

import java.util.List;
import net.frozenblock.lib.worldgen.feature.api.FrozenLibPlacedFeature;
import net.frozenblock.wilderwild_japanese_maple.WWJMConstants;
import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import org.jetbrains.annotations.NotNull;

public final class WWJMPlacementUtils {

	private WWJMPlacementUtils() {
		throw new UnsupportedOperationException("WWJMPlacementUtils contains only static declarations.");
	}

	@NotNull
	@SuppressWarnings({"unchecked", "rawtypes"})
	public static <FC extends FeatureConfiguration> FrozenLibPlacedFeature register(
		@NotNull String id, Holder<ConfiguredFeature<FC, ?>> configured, @NotNull List<PlacementModifier> modifiers
	) {
		return new FrozenLibPlacedFeature(WWJMConstants.id(id)).makeAndSetHolder((Holder) configured, modifiers);
	}

	@NotNull
	public static <FC extends FeatureConfiguration> FrozenLibPlacedFeature register(
		@NotNull String id, Holder<ConfiguredFeature<FC, ?>> registryEntry, @NotNull PlacementModifier... modifiers
	) {
		return register(id, registryEntry, List.of(modifiers));
	}

	@NotNull
	public static FrozenLibPlacedFeature register(@NotNull String id) {
		return new FrozenLibPlacedFeature(WWJMConstants.id(id));
	}

}
