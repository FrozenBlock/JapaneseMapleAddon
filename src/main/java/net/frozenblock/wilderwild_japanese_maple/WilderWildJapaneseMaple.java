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

package net.frozenblock.wilderwild_japanese_maple;

import net.fabricmc.loader.api.ModContainer;
import net.frozenblock.lib.entrypoint.api.FrozenModInitializer;
import net.frozenblock.wilderwild_japanese_maple.registry.WWJMBlocks;
import net.frozenblock.wilderwild_japanese_maple.registry.WWJMParticleTypes;
import net.frozenblock.wilderwild_japanese_maple.registry.WWJMVillagers;
import net.frozenblock.wilderwild_japanese_maple.worldgen.modification.WWJMWorldgen;

public final class WilderWildJapaneseMaple extends FrozenModInitializer {

	public WilderWildJapaneseMaple() {
		super(WWJMConstants.MOD_ID);
	}

	@Override
	public void onInitialize(String modId, ModContainer container) {
		WWJMBlocks.registerBlocks();
		WWJMParticleTypes.registerParticles();
		WWJMVillagers.register();
		WWJMWorldgen.generate();
	}

}
