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

package net.frozenblock.wilderwild_japanese_maple.datagen.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.frozenblock.wilderwild.datagen.model.WWModelHelper;
import net.frozenblock.wilderwild_japanese_maple.registry.WWJMBlocks;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.TexturedModel;
import org.jetbrains.annotations.NotNull;

@Environment(EnvType.CLIENT)
public final class WWJMModelProvider extends FabricModelProvider {

	public WWJMModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(@NotNull BlockModelGenerators generator) {
		generator.createPlant(WWJMBlocks.JAPANESE_MAPLE_SAPLING, WWJMBlocks.POTTED_JAPANESE_MAPLE_SAPLING, net.minecraft.data.models.BlockModelGenerators.TintState.NOT_TINTED);
		generator.createTrivialBlock(WWJMBlocks.JAPANESE_MAPLE_LEAVES, TexturedModel.LEAVES);
		WWModelHelper.createLeafLitter(generator, WWJMBlocks.JAPANESE_MAPLE_LEAF_LITTER);
	}

	@Override
	public void generateItemModels(@NotNull ItemModelGenerators generator) {
	}
}
