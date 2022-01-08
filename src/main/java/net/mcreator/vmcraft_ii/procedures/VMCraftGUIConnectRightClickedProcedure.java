package net.mcreator.vmcraft_ii.procedures;

import net.minecraftforge.fmllegacy.server.ServerLifecycleHooks;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.ChatType;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.Util;

import net.mcreator.vmcraft_ii.network.VmcraftIiModVariables;

import java.util.HashMap;

public class VMCraftGUIConnectRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		VmcraftIiModVariables.errorMessage = "";
		if ((guistate.containsKey("text:ipAddress") ? ((EditBox) guistate.get("text:ipAddress")).getValue() : "").equals("")
				&& (guistate.containsKey("text:portNumber") ? ((EditBox) guistate.get("text:portNumber")).getValue() : "").equals("")) {
			if ((new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getTileData().getString(tag);
					return "";
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "ipAddress")).equals("") || (new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getTileData().getString(tag);
					return "";
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "portNumber")).equals("")) {
				VmcraftIiModVariables.errorMessage = "Invalid IP address.";
			}
		} else {
			if ((guistate.containsKey("text:ipAddress") ? ((EditBox) guistate.get("text:ipAddress")).getValue() : "").matches("^([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])$")) {
				if ((guistate.containsKey("text:portNumber") ? ((EditBox) guistate.get("text:portNumber")).getValue() : "").matches("^[0-9]{1,5}$")) {
					if (!world.isClientSide()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getTileData().putString("ipAddress",
									(guistate.containsKey("text:ipAddress") ? ((EditBox) guistate.get("text:ipAddress")).getValue() : ""));
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (!world.isClientSide()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getTileData().putString("portNumber",
									(guistate.containsKey("text:portNumber") ? ((EditBox) guistate.get("text:portNumber")).getValue() : ""));
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (!(guistate.containsKey("text:username") ? ((EditBox) guistate.get("text:username")).getValue() : "").equals("")) {
						if (!world.isClientSide()) {
							BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getTileData().putString("username",
										(guistate.containsKey("text:username") ? ((EditBox) guistate.get("text:username")).getValue() : ""));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (!(guistate.containsKey("text:password") ? ((EditBox) guistate.get("text:password")).getValue() : "").equals("")) {
						if (!world.isClientSide()) {
							BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getTileData().putString("password",
										(guistate.containsKey("text:password") ? ((EditBox) guistate.get("text:password")).getValue() : ""));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
				} else {
					VmcraftIiModVariables.errorMessage = "Invalid port number.";
				}
			} else {
				VmcraftIiModVariables.errorMessage = "Invalid IP address.";
			}
		}
		if ((VmcraftIiModVariables.errorMessage).equals("")) {
			if (!world.isClientSide()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList()
							.broadcastMessage(new TextComponent((entity.getDisplayName().getString() + " connected to " + (new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getTileData().getString(tag);
									return "";
								}
							}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "ipAddress")) + ":" + (new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getTileData().getString(tag);
									return "";
								}
							}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "portNumber")) + ".")), ChatType.SYSTEM, Util.NIL_UUID);
			}
		}
	}
}
