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

package net.frozenblock.wilderwild_japanese_maple.datagen.tag;

import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.frozenblock.wilderwild_japanese_maple.registry.WWJMBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import org.jetbrains.annotations.NotNull;

public final class WWJMItemTagProvider extends FabricTagProvider.ItemTagProvider {

	public WWJMItemTagProvider(@NotNull FabricDataOutput output, @NotNull CompletableFuture<HolderLookup.Provider> registries) {
		super(output, registries);
	}

	@Override
	protected void addTags(@NotNull HolderLookup.Provider arg) {
		this.getOrCreateTagBuilder(ItemTags.LEAVES)
			.add(WWJMBlocks.JAPANESE_MAPLE_LEAVES.asItem());

		this.getOrCreateTagBuilder(ItemTags.SAPLINGS)
			.add(WWJMBlocks.JAPANESE_MAPLE_SAPLING.asItem());
	}
}
