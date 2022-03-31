
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.vmcraft_ii.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.block.Block;

import net.mcreator.vmcraft_ii.block.LaptopBlock;
import net.mcreator.vmcraft_ii.block.ComputerBlock;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class VmcraftIiModBlocks {
	private static final List<Block> REGISTRY = new ArrayList<>();
	public static final Block COMPUTER = register(new ComputerBlock());
	public static final Block LAPTOP = register(new LaptopBlock());

	private static Block register(Block block) {
		REGISTRY.add(block);
		return block;
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Block[0]));
	}
}
