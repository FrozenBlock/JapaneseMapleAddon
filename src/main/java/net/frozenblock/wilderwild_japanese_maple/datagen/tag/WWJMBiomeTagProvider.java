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

package net.frozenblock.wilderwild_japanese_maple.datagen.tag;

import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.frozenblock.lib.datagen.api.FrozenBiomeTagProvider;
import net.frozenblock.wilderwild.registry.WWBiomes;
import net.frozenblock.wilderwild_japanese_maple.tag.WWJMBiomeTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.biome.Biomes;
import org.jetbrains.annotations.NotNull;

public final class WWJMBiomeTagProvider extends FrozenBiomeTagProvider {

	public WWJMBiomeTagProvider(@NotNull FabricDataOutput output, @NotNull CompletableFuture registries) {
		super(output, registries);
	}

	@Override
	protected void addTags(@NotNull HolderLookup.Provider arg) {
		this.getOrCreateTagBuilder(WWJMBiomeTags.HAS_JAPANESE_MAPLE);

		this.getOrCreateTagBuilder(WWJMBiomeTags.HAS_JAPANESE_MAPLE_SPARSE)
			.add(Biomes.FLOWER_FOREST);

		this.getOrCreateTagBuilder(WWJMBiomeTags.HAS_JAPANESE_MAPLE_SHORTER_SPARSE)
			.add(Biomes.DARK_FOREST)
			.addOptional(WWBiomes.OLD_GROWTH_DARK_FOREST);
	}
}
