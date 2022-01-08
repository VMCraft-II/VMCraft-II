package net.mcreator.vmcraft_ii.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.vmcraft_ii.network.VmcraftIiModVariables;

public class VMCraftGUIExitRightClickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		VmcraftIiModVariables.errorMessage = "";
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}
