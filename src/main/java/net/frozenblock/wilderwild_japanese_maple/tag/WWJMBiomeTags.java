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

package net.frozenblock.wilderwild_japanese_maple.tag;

import net.frozenblock.wilderwild_japanese_maple.WWJMConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import org.jetbrains.annotations.NotNull;

public final class WWJMBiomeTags {
	public static final TagKey<Biome> HAS_JAPANESE_MAPLE = bind("feature/has_japanese_maple");
	public static final TagKey<Biome> HAS_JAPANESE_MAPLE_SPARSE = bind("feature/has_japanese_maple_sparse");
	public static final TagKey<Biome> HAS_JAPANESE_MAPLE_SHORTER_SPARSE = bind("feature/has_japanese_maple_shorter_sparse");

	private WWJMBiomeTags() {
		throw new UnsupportedOperationException("WWJMBiomeTags contains only static declarations.");
	}

	@NotNull
	private static TagKey<Biome> bind(@NotNull String path) {
		return TagKey.create(Registries.BIOME, WWJMConstants.id(path));
	}
}
