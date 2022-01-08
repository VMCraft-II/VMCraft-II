
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.vmcraft_ii.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class VmcraftIiModTabs {
	public static CreativeModeTab TAB_VM_CRAFT;

	public static void load() {
		TAB_VM_CRAFT = new CreativeModeTab("tabvm_craft") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(VmcraftIiModBlocks.COMPUTER);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
