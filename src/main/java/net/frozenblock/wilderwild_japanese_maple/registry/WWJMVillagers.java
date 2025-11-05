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

package net.frozenblock.wilderwild_japanese_maple.registry;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.frozenblock.wilderwild.config.WWEntityConfig;
import net.minecraft.world.entity.npc.VillagerTrades;

public final class WWJMVillagers {

	private WWJMVillagers() {
		throw new UnsupportedOperationException("WWJMVillagers contains only static declarations.");
	}

	public static void register() {
		TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
			final WWEntityConfig.VillagerConfig config = WWEntityConfig.get().villager;
			if (config.wanderingMapleSaplingTrade) factories.add(new VillagerTrades.ItemsForEmeralds(WWJMBlocks.JAPANESE_MAPLE_SAPLING.asItem(), 5, 1, 8, 1));
		});
	}
}
