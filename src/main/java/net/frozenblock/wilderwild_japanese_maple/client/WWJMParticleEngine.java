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

package net.frozenblock.wilderwild_japanese_maple.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.frozenblock.wilderwild.particle.LeafParticle;
import net.frozenblock.wilderwild_japanese_maple.registry.WWJMParticleTypes;

@Environment(EnvType.CLIENT)
public final class WWJMParticleEngine {

	public static void init() {
		ParticleFactoryRegistry particleRegistry = ParticleFactoryRegistry.getInstance();
		particleRegistry.register(WWJMParticleTypes.JAPANESE_MAPLE_LEAVES, LeafParticle.Provider::new);
	}
}
