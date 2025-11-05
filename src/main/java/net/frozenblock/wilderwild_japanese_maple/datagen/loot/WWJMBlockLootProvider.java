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

package net.frozenblock.wilderwild_japanese_maple.datagen.loot;

import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.frozenblock.wilderwild.datagen.loot.WWBlockLootHelper;
import net.frozenblock.wilderwild_japanese_maple.registry.WWJMBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.Enchantment;
import org.jetbrains.annotations.NotNull;

public final class WWJMBlockLootProvider extends FabricBlockLootTableProvider {

	public WWJMBlockLootProvider(@NotNull FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registries) {
		super(dataOutput, registries);
	}

	@Override
	public void generate() {
		HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

		this.dropSelf(WWJMBlocks.JAPANESE_MAPLE_SAPLING);
		this.add(WWJMBlocks.JAPANESE_MAPLE_LEAVES, block -> this.createLeavesDrops(block, WWJMBlocks.JAPANESE_MAPLE_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
		this.dropPottedContents(WWJMBlocks.POTTED_JAPANESE_MAPLE_SAPLING);
		WWBlockLootHelper.makeShearsOrSilkTouchRequiredLoot(this, WWJMBlocks.JAPANESE_MAPLE_LEAF_LITTER);

	}

}
