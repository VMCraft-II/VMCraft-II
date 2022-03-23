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

public class VMCraftGUISaveRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		{
			String _setval = "";
			entity.getCapability(VmcraftIiModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.guiMessage = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if ((guistate.containsKey("text:ipAddress") ? ((EditBox) guistate.get("text:ipAddress")).getValue() : "").equals("")
				&& (guistate.containsKey("text:portNumber") ? ((EditBox) guistate.get("text:portNumber")).getValue() : "").equals("")
				&& (guistate.containsKey("text:vmID") ? ((EditBox) guistate.get("text:vmID")).getValue() : "").equals("")
				&& (guistate.containsKey("text:vmName") ? ((EditBox) guistate.get("text:vmName")).getValue() : "").equals("")
				&& (guistate.containsKey("text:nodeName") ? ((EditBox) guistate.get("text:nodeName")).getValue() : "").equals("")) {
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
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "portNumber")).equals("") || (new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getTileData().getString(tag);
					return "";
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "vmID")).equals("") || (new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getTileData().getString(tag);
					return "";
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "vmName")).equals("") || (new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getTileData().getString(tag);
					return "";
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "nodeName")).equals("")) {
				{
					String _setval = "Invalid IP address.";
					entity.getCapability(VmcraftIiModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.guiMessage = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else {
			if ((guistate.containsKey("text:ipAddress") ? ((EditBox) guistate.get("text:ipAddress")).getValue() : "").matches("^([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])$")) {
				if ((guistate.containsKey("text:portNumber") ? ((EditBox) guistate.get("text:portNumber")).getValue() : "").matches("^[1-9][0-9]{0,4}$")) {
					if ((guistate.containsKey("text:vmID") ? ((EditBox) guistate.get("text:vmID")).getValue() : "").matches("^[1-9]|[1-9][0-9]|[1-9][0-9][0-9]$")) {
						if ((guistate.containsKey("text:vmName") ? ((EditBox) guistate.get("text:vmName")).getValue() : "").matches("^[a-zA-Z1-9]+$")) {
							if ((guistate.containsKey("text:nodeName") ? ((EditBox) guistate.get("text:nodeName")).getValue() : "").matches("^[a-zA-Z1-9]+$")) {
								if (!world.isClientSide()) {
									BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null)
										_blockEntity.getTileData().putString("ipAddress",
												(guistate.containsKey("text:ipAddress")
														? ((EditBox) guistate.get("text:ipAddress")).getValue()
														: ""));
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
								if (!world.isClientSide()) {
									BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null)
										_blockEntity.getTileData().putString("portNumber",
												(guistate.containsKey("text:portNumber")
														? ((EditBox) guistate.get("text:portNumber")).getValue()
														: ""));
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
								if (!world.isClientSide()) {
									BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null)
										_blockEntity.getTileData().putString("vmID",
												(guistate.containsKey("text:vmID") ? ((EditBox) guistate.get("text:vmID")).getValue() : ""));
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
								if (!world.isClientSide()) {
									BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null)
										_blockEntity.getTileData().putString("vmName",
												(guistate.containsKey("text:vmName") ? ((EditBox) guistate.get("text:vmName")).getValue() : ""));
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
								if (!world.isClientSide()) {
									BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null)
										_blockEntity.getTileData().putString("nodeName",
												(guistate.containsKey("text:nodeName") ? ((EditBox) guistate.get("text:nodeName")).getValue() : ""));
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
							} else {
								{
									String _setval = "Invalid node name.";
									entity.getCapability(VmcraftIiModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.guiMessage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else {
							{
								String _setval = "Invalid VM name.";
								entity.getCapability(VmcraftIiModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.guiMessage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else {
						{
							String _setval = "Invalid VM ID.";
							entity.getCapability(VmcraftIiModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.guiMessage = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				} else {
					{
						String _setval = "Invalid port number.";
						entity.getCapability(VmcraftIiModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.guiMessage = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else {
				{
					String _setval = "Invalid IP address.";
					entity.getCapability(VmcraftIiModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.guiMessage = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if (((entity.getCapability(VmcraftIiModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new VmcraftIiModVariables.PlayerVariables())).guiMessage).equals("")) {
			if (!world.isClientSide()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList()
							.broadcastMessage(new TextComponent((entity.getDisplayName().getString() + " saved " + "https://" + (new Object() {
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
							}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "portNumber")) + "/?console=kvm&novnc=1&vmid="
									+ (new Object() {
										public String getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getTileData().getString(tag);
											return "";
										}
									}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "vmID")) + "&vmname=" + (new Object() {
										public String getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getTileData().getString(tag);
											return "";
										}
									}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "vmName")) + "&node=" + (new Object() {
										public String getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getTileData().getString(tag);
											return "";
										}
									}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "nodeName")) + "&resize=off&cmd= to block.")),
									ChatType.SYSTEM, Util.NIL_UUID);
			}
			{
				String _setval = "Saved.";
				entity.getCapability(VmcraftIiModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.guiMessage = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
