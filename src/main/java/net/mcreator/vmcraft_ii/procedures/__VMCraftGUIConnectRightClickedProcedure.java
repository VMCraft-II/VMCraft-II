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
		VmcraftIiModVariables.guiMessage = "";
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
				VmcraftIiModVariables.guiMessage = "Invalid IP address.";
			}
		} else {
			if ((guistate.containsKey("text:ipAddress") ? ((EditBox) guistate.get("text:ipAddress")).getValue() : "").matches("^([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])$")) {
				if ((guistate.containsKey("text:portNumber") ? ((EditBox) guistate.get("text:portNumber")).getValue() : "").matches("^[1-9][0-9]{0,4}$")) {
					if (!(VmcraftIiModVariables.connectionType).equals("Connection Type")) {
						if (!(VmcraftIiModVariables.backendServer).equals("Backend Server")) {
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
						} else {
							VmcraftIiModVariables.guiMessage = "Invalid backend server.";
						}
					} else {
						VmcraftIiModVariables.guiMessage = "Invalid connection type.";
					}
				} else {
					VmcraftIiModVariables.guiMessage = "Invalid port number.";
				}
			} else {
				VmcraftIiModVariables.guiMessage = "Invalid IP address.";
			}
		}
		if ((VmcraftIiModVariables.guiMessage).equals("")) {
			if (!world.isClientSide()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList()
							.broadcastMessage(new TextComponent((entity.getDisplayName().getString() + " attempting to connect to " + (new Object() {
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
			VmcraftIiModVariables.guiMessage = (new Object() {
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
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "portNumber"));



			File f = File.createTempFile("tmp", "vv");
   			FileWriter out = new FileWriter(f.getAbsolutePath());
   			
   			// write connection info to .vv file
   			out.write("[virt-viewer]\n");
   			out.write(String.format("type=%s\n", (this.isSpice ? "spice" : "vnc")));
   			// only write these portions if they contain something
   			if(this.hostnameTxt.getText() != "")
   				out.write(String.format("host=%s\n", this.hostnameTxt.getText()));
   			if(this.portTxt.getText() != "")
   				out.write(String.format("port=%s\n", this.portTxt.getText()));
   			if(this.usernameTxt.getText() != "")
   				out.write(String.format("username=%s\n", this.usernameTxt.getText()));
   			if(this.passwordTxt.getText() != "")
   				out.write(String.format("password=%s\n", this.passwordTxt.getText()));
   			out.write("fullscreen=1\n");
   			out.write("delete-this-file=1\n");
   			out.close();
   			
   			String command = String.format("remote-viewer %s", f.getAbsolutePath());
   			Runtime.getRuntime().exec(command);
		}
	}
}
