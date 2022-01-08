package net.mcreator.vmcraft_ii.network;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class VmcraftIiModVariables {
	public static String connectionType = "Connection Type";
	public static String backendServer = "Backend Server";
	public static String errorMessage = "";

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
	}
}
