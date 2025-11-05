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

package net.frozenblock.wilderwild_japanese_maple;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.frozenblock.lib.menu.api.SplashTextAPI;
import net.frozenblock.wilderwild_japanese_maple.client.WWJMBlockRenderLayers;
import net.frozenblock.wilderwild_japanese_maple.client.WWJMParticleEngine;

@Environment(EnvType.CLIENT)
public final class WilderWildJapaneseMapleClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		SplashTextAPI.addSplashLocation(WWJMConstants.id("texts/splashes.txt"));

		WWJMBlockRenderLayers.init();
		WWJMParticleEngine.init();
	}

}
