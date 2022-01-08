
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.vmcraft_ii.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.vmcraft_ii.client.gui.VMCraftGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class VmcraftIiModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(VmcraftIiModMenus.VM_CRAFT_GUI, VMCraftGUIScreen::new);
		});
	}
}
