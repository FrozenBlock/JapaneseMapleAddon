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

package net.frozenblock.wilderwild_japanese_maple.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.frozenblock.lib.feature_flag.api.FeatureFlagApi;
import net.frozenblock.wilderwild_japanese_maple.WWJMConstants;
import net.frozenblock.wilderwild_japanese_maple.datagen.loot.WWJMBlockLootProvider;
import net.frozenblock.wilderwild_japanese_maple.datagen.model.WWJMModelProvider;
import net.frozenblock.wilderwild_japanese_maple.datagen.tag.WWJMBiomeTagProvider;
import net.frozenblock.wilderwild_japanese_maple.datagen.tag.WWJMBlockTagProvider;
import net.frozenblock.wilderwild_japanese_maple.datagen.tag.WWJMItemTagProvider;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import org.jetbrains.annotations.NotNull;

public final class WWJMDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(@NotNull FabricDataGenerator dataGenerator) {
		FeatureFlagApi.rebuild();
		final FabricDataGenerator.Pack pack = dataGenerator.createPack();

		// ASSETS

		pack.addProvider(WWJMModelProvider::new);

		// DATA

		// When adding a registry to generate, don't forget this!
		pack.addProvider(WWJMRegistryProvider::new);

		pack.addProvider(WWJMBlockLootProvider::new);
		pack.addProvider(WWJMBiomeTagProvider::new);
		pack.addProvider(WWJMBlockTagProvider::new);
		pack.addProvider(WWJMItemTagProvider::new);
	}

	@Override
	public void buildRegistry(@NotNull RegistrySetBuilder registryBuilder) {
		WWJMConstants.logWithModId("Generating dynamic registries for", WWJMConstants.UNSTABLE_LOGGING);

		registryBuilder.add(Registries.CONFIGURED_FEATURE, WWJMFeatureBootstrap::bootstrapConfigured);
		registryBuilder.add(Registries.PLACED_FEATURE, WWJMFeatureBootstrap::bootstrapPlaced);
	}

	@Override
	public @NotNull String getEffectiveModId() {
		return WWJMConstants.MOD_ID;
	}
}
