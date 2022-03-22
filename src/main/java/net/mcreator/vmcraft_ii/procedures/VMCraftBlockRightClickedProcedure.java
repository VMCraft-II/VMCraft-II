package net.mcreator.vmcraft_ii.procedures;

import net.minecraftforge.fmllegacy.server.ServerLifecycleHooks;
import net.minecraftforge.fmllegacy.network.NetworkHooks;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.Util;

import net.mcreator.vmcraft_ii.world.inventory.VMCraftGUIMenu;
import net.mcreator.vmcraft_ii.network.VmcraftIiModVariables;
import net.mcreator.vmcraft_ii.init.VmcraftIiModItems;

import io.netty.buffer.Unpooled;

import net.minecraft.world.level.block.state.BlockState;
import java.io.IOException;

public class VMCraftBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!((new Object() {
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
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "nodeName")).equals(""))) {
			{
				String _setval = "https://" + (new Object() {
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
				}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "portNumber")) + "/?console=kvm&novnc=1&vmid=" + (new Object() {
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
				}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "nodeName")) + "&resize=off&cmd=";
				entity.getCapability(VmcraftIiModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.guiMessage = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				String _setval = "";
				entity.getCapability(VmcraftIiModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.guiMessage = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == VmcraftIiModItems.CONFIGURATION_KEY) {
			{
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = new BlockPos((int) x, (int) y, (int) z);
					NetworkHooks.openGui((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return new TextComponent("VMCraftGUI");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new VMCraftGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		} else {
			if (((entity.getCapability(VmcraftIiModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new VmcraftIiModVariables.PlayerVariables())).guiMessage).equals("")) {
				if (!world.isClientSide()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().broadcastMessage(new TextComponent("This block has not been configured."), ChatType.SYSTEM,
								Util.NIL_UUID);
				}
			} else {
				String myOS = System.getProperty("os.name").toLowerCase();
				
				try {
					Runtime runtime = Runtime.getRuntime();
					
					if(myOS.contains("windows")) {
						runtime.exec("rundll32 url.dll,FileProtocolHandler " + ((entity.getCapability(VmcraftIiModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new VmcraftIiModVariables.PlayerVariables())).guiMessage));
						
						if (!world.isClientSide()) {
							MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
							if (mcserv != null)
								mcserv.getPlayerList().broadcastMessage(
										new TextComponent((entity.getDisplayName().getString() + " successfully connected to " + "https://" + (new Object() {
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
												}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "nodeName")) + "&resize=off&cmd=")),
										ChatType.SYSTEM, Util.NIL_UUID);
						}
					} else if(myOS.contains("mac")) {
						runtime.exec("open " + ((entity.getCapability(VmcraftIiModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new VmcraftIiModVariables.PlayerVariables())).guiMessage));
						
						if (!world.isClientSide()) {
							MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
							if (mcserv != null)
								mcserv.getPlayerList().broadcastMessage(
										new TextComponent((entity.getDisplayName().getString() + " successfully connected to " + "https://" + (new Object() {
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
												}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "nodeName")) + "&resize=off&cmd=")),
										ChatType.SYSTEM, Util.NIL_UUID);
						}
					} else if(myOS.contains("nix") || myOS.contains("nux")) {
						runtime.exec("xdg-open " + ((entity.getCapability(VmcraftIiModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new VmcraftIiModVariables.PlayerVariables())).guiMessage));
						
						if (!world.isClientSide()) {
							MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
							if (mcserv != null)
								mcserv.getPlayerList().broadcastMessage(
										new TextComponent((entity.getDisplayName().getString() + " successfully connected to " + "https://" + (new Object() {
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
												}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "nodeName")) + "&resize=off&cmd=")),
										ChatType.SYSTEM, Util.NIL_UUID);
						}
					} else {
						if (!world.isClientSide()) {
							MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
							if (mcserv != null)
								mcserv.getPlayerList().broadcastMessage(
										new TextComponent((entity.getDisplayName().getString() + " failed to connect to " + "https://" + (new Object() {
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
												}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "nodeName")) + "&resize=off&cmd=")),
										ChatType.SYSTEM, Util.NIL_UUID);
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
