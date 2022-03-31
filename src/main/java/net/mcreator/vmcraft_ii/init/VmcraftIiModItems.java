
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.vmcraft_ii.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.vmcraft_ii.item.ConfigurationKeyItem;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class VmcraftIiModItems {
	private static final List<Item> REGISTRY = new ArrayList<>();
	public static final Item COMPUTER = register(VmcraftIiModBlocks.COMPUTER, VmcraftIiModTabs.TAB_VM_CRAFT);
	public static final Item CONFIGURATION_KEY = register(new ConfigurationKeyItem());
	public static final Item LAPTOP = register(VmcraftIiModBlocks.LAPTOP, VmcraftIiModTabs.TAB_VM_CRAFT);

	private static Item register(Item item) {
		REGISTRY.add(item);
		return item;
	}

	private static Item register(Block block, CreativeModeTab tab) {
		return register(new BlockItem(block, new Item.Properties().tab(tab)).setRegistryName(block.getRegistryName()));
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Item[0]));
	}
}
