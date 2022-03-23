
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.vmcraft_ii.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.vmcraft_ii.block.entity.LaptopBlockEntity;
import net.mcreator.vmcraft_ii.block.entity.ComputerBlockEntity;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class VmcraftIiModBlockEntities {
	private static final List<BlockEntityType<?>> REGISTRY = new ArrayList<>();
	public static final BlockEntityType<?> COMPUTER = register("vmcraft_ii:computer", VmcraftIiModBlocks.COMPUTER, ComputerBlockEntity::new);
	public static final BlockEntityType<?> LAPTOP = register("vmcraft_ii:laptop", VmcraftIiModBlocks.LAPTOP, LaptopBlockEntity::new);

	private static BlockEntityType<?> register(String registryname, Block block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		BlockEntityType<?> blockEntityType = BlockEntityType.Builder.of(supplier, block).build(null).setRegistryName(registryname);
		REGISTRY.add(blockEntityType);
		return blockEntityType;
	}

	@SubscribeEvent
	public static void registerTileEntity(RegistryEvent.Register<BlockEntityType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new BlockEntityType[0]));
	}
}
