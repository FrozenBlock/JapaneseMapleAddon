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

package net.frozenblock.wilderwild_japanese_maple.mod_compat;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.frozenblock.lib.integration.api.ModIntegration;
import net.frozenblock.wilderwild_japanese_maple.registry.WWJMBlocks;
import net.frozenblock.wilderwild_japanese_maple.registry.WWJMParticleTypes;
import net.frozenblock.wilderwild_japanese_maple.registry.WWJMVillagers;
import net.frozenblock.wilderwild_japanese_maple.worldgen.modification.WWJMWorldgen;

public class FrozenLibIntegration extends ModIntegration {

	public FrozenLibIntegration() {
		super("frozenlib");
	}

	@Override
	public void initPreFreeze() {
		WWJMBlocks.registerBlocks();
		WWJMParticleTypes.registerParticles();
		WWJMVillagers.register();
		WWJMWorldgen.generate();
	}

	@Override
	public void init() {

	}

	@Environment(EnvType.CLIENT)
	@Override
	public void clientInit() {
	}
}
