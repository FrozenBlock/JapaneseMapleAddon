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
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.frozenblock.wilderwild.tag.WWBlockTags;
import net.frozenblock.wilderwild_japanese_maple.registry.WWJMBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import org.jetbrains.annotations.NotNull;

public final class WWJMBlockTagProvider extends FabricTagProvider.BlockTagProvider {

	public WWJMBlockTagProvider(@NotNull FabricDataOutput output, @NotNull CompletableFuture<HolderLookup.Provider> registries) {
		super(output, registries);
	}

	@Override
	protected void addTags(@NotNull HolderLookup.Provider arg) {
		this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_HOE)
			.add(WWJMBlocks.JAPANESE_MAPLE_LEAVES);

		this.getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
			.add(WWJMBlocks.POTTED_JAPANESE_MAPLE_SAPLING);

		this.getOrCreateTagBuilder(BlockTags.LEAVES)
			.add(WWJMBlocks.JAPANESE_MAPLE_LEAVES);

		this.getOrCreateTagBuilder(WWBlockTags.LEAF_LITTERS)
			.add(WWJMBlocks.JAPANESE_MAPLE_LEAF_LITTER);

		this.getOrCreateTagBuilder(BlockTags.SAPLINGS)
			.add(WWJMBlocks.JAPANESE_MAPLE_SAPLING);

		this.getOrCreateTagBuilder(WWBlockTags.SOUND_SAPLING)
			.add(WWJMBlocks.JAPANESE_MAPLE_SAPLING);
	}

}
