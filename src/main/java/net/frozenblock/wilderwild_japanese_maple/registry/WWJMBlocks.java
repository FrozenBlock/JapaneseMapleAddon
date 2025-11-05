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

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.frozenblock.lib.item.api.FrozenCreativeTabs;
import net.frozenblock.wilderwild.block.LeafLitterBlock;
import net.frozenblock.wilderwild.block.LeavesWithLitterBlock;
import net.frozenblock.wilderwild.config.WWAmbienceAndMiscConfig;
import net.frozenblock.wilderwild.registry.WWBlocks;
import net.frozenblock.wilderwild.registry.WWSoundTypes;
import net.frozenblock.wilderwild_japanese_maple.WWJMConstants;
import net.frozenblock.wilderwild_japanese_maple.worldgen.impl.sapling.WWJMTreeGrowers;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public final class WWJMBlocks {
	public static final Block JAPANESE_MAPLE_LEAVES = new LeavesWithLitterBlock(
		BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)
			.mapColor(MapColor.COLOR_PURPLE)
			.sound(WWSoundTypes.MAPLE_LEAVES)
	);

	public static final LeafLitterBlock JAPANESE_MAPLE_LEAF_LITTER = WWBlocks.leafLitter(
		JAPANESE_MAPLE_LEAVES,
		WWJMParticleTypes.JAPANESE_MAPLE_LEAVES,
		0.04F,
		() -> WWAmbienceAndMiscConfig.Client.MAPLE_LEAF_FREQUENCY,
		5,
		WWSoundTypes.MAPLE_LEAF_LITTER
	);

	public static final SaplingBlock JAPANESE_MAPLE_SAPLING = new SaplingBlock(
		WWJMTreeGrowers.JAPANESE_MAPLE,
		BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_SAPLING)
	);

	public static final Block POTTED_JAPANESE_MAPLE_SAPLING = Blocks.flowerPot(JAPANESE_MAPLE_SAPLING);

	private WWJMBlocks() {
		throw new UnsupportedOperationException("WWJMBlocks contains only static declarations.");
	}

	private static void registerBlock(String path, Block block) {
		actualRegisterBlock(path, block);
	}

	@SafeVarargs
	private static void registerBlockBefore(ItemLike comparedItem, String path, Block block, ResourceKey<CreativeModeTab>... tabs) {
		registerBlockItemBefore(comparedItem, path, block, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS, tabs);
		actualRegisterBlock(path, block);
	}

	@SafeVarargs
	private static void registerBlockAfter(ItemLike comparedItem, String path, Block block, ResourceKey<CreativeModeTab>... tabs) {
		registerBlockItemAfter(comparedItem, path, block, tabs);
		actualRegisterBlock(path, block);
	}

	@SafeVarargs
	private static void registerBlockItemBefore(ItemLike comparedItem, String path, Block block, CreativeModeTab.TabVisibility tabVisibility, ResourceKey<CreativeModeTab>... tabs) {
		actualRegisterBlockItem(path, block);
		FrozenCreativeTabs.addBefore(comparedItem, block, tabVisibility, tabs);
	}

	@SafeVarargs
	private static void registerBlockItemAfter(ItemLike comparedItem, String name, Block block, ResourceKey<CreativeModeTab>... tabs) {
		registerBlockItemAfter(comparedItem, name, block, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS, tabs);
	}

	@SafeVarargs
	private static void registerBlockItemAfter(ItemLike comparedItem, String path, Block block, CreativeModeTab.TabVisibility visibility, ResourceKey<CreativeModeTab>... tabs) {
		actualRegisterBlockItem(path, block);
		FrozenCreativeTabs.addAfter(comparedItem, block, visibility, tabs);
	}

	private static void actualRegisterBlock(String path, Block block) {
		if (BuiltInRegistries.BLOCK.getOptional(WWJMConstants.id(path)).isEmpty()) Registry.register(BuiltInRegistries.BLOCK, WWJMConstants.id(path), block);
	}

	private static void actualRegisterBlockItem(String path, Block block) {
		if (BuiltInRegistries.ITEM.getOptional(WWJMConstants.id(path)).isEmpty()) {
			Registry.register(
				BuiltInRegistries.ITEM,
				WWJMConstants.id(path),
				new BlockItem(block, new Item.Properties())
			);
		}
	}

	public static void registerBlocks() {
		WWJMConstants.logWithModId("Registering Blocks for", WWJMConstants.UNSTABLE_LOGGING);
		registerBlockAfter(WWBlocks.RED_MAPLE_LEAF_LITTER, "japanese_maple_leaves", JAPANESE_MAPLE_LEAVES, CreativeModeTabs.NATURAL_BLOCKS);
		registerBlockAfter(JAPANESE_MAPLE_LEAVES, "japanese_maple_leaf_litter", JAPANESE_MAPLE_LEAF_LITTER, CreativeModeTabs.NATURAL_BLOCKS);
		registerBlockAfter(WWBlocks.RED_MAPLE_SAPLING, "japanese_maple_sapling", JAPANESE_MAPLE_SAPLING, CreativeModeTabs.NATURAL_BLOCKS);
		registerBlock("potted_japanese_maple_sapling", POTTED_JAPANESE_MAPLE_SAPLING);

		registerStrippable();
		registerComposting();
		registerFlammability();
		registerFuels();
		registerBonemeal();
		registerAxe();
	}

	private static void registerStrippable() {

	}

	private static void registerComposting() {
		CompostingChanceRegistry.INSTANCE.add(JAPANESE_MAPLE_LEAVES, 0.3F);
		CompostingChanceRegistry.INSTANCE.add(JAPANESE_MAPLE_SAPLING, 0.3F);
		CompostingChanceRegistry.INSTANCE.add(JAPANESE_MAPLE_LEAF_LITTER, 0.1F);
	}

	private static void registerFlammability() {
		WWJMConstants.logWithModId("Registering Flammability for", WWJMConstants.UNSTABLE_LOGGING);
		var flammableBlockRegistry = FlammableBlockRegistry.getDefaultInstance();
		flammableBlockRegistry.add(JAPANESE_MAPLE_LEAVES, 30, 60);
		flammableBlockRegistry.add(JAPANESE_MAPLE_LEAF_LITTER, 60, 100);
	}

	private static void registerFuels() {
		WWJMConstants.logWithModId("Registering Fuels for", WWJMConstants.UNSTABLE_LOGGING);
		FuelRegistry registry = FuelRegistry.INSTANCE;
		registry.add(JAPANESE_MAPLE_SAPLING.asItem(), 100);
	}

	private static void registerBonemeal() {

	}

	private static void registerAxe() {

	}
}
