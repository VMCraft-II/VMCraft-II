
package net.mcreator.vmcraft_ii.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.vmcraft_ii.world.inventory.VMCraftGUIMenu;
import net.mcreator.vmcraft_ii.network.VmcraftIiModVariables;
import net.mcreator.vmcraft_ii.network.VMCraftGUIButtonMessage;
import net.mcreator.vmcraft_ii.VmcraftIiMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class VMCraftGUIScreen extends AbstractContainerScreen<VMCraftGUIMenu> {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox ipAddress;
	EditBox portNumber;
	EditBox vmID;
	EditBox vmName;
	EditBox nodeName;

	public VMCraftGUIScreen(VMCraftGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 261;
		this.imageHeight = 114;
	}

	@Override
	public boolean isPauseScreen() {
		return true;
	}

	private static final ResourceLocation texture = new ResourceLocation("vmcraft_ii:textures/vm_craft_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		ipAddress.render(ms, mouseX, mouseY, partialTicks);
		portNumber.render(ms, mouseX, mouseY, partialTicks);
		vmID.render(ms, mouseX, mouseY, partialTicks);
		vmName.render(ms, mouseX, mouseY, partialTicks);
		nodeName.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (ipAddress.isFocused())
			return ipAddress.keyPressed(key, b, c);
		if (portNumber.isFocused())
			return portNumber.keyPressed(key, b, c);
		if (vmID.isFocused())
			return vmID.keyPressed(key, b, c);
		if (vmName.isFocused())
			return vmName.keyPressed(key, b, c);
		if (nodeName.isFocused())
			return nodeName.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		ipAddress.tick();
		portNumber.tick();
		vmID.tick();
		vmName.tick();
		nodeName.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "Connection Information", 75, 5, -16777216);
		this.font.draw(poseStack, "" + ((entity.getCapability(VmcraftIiModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new VmcraftIiModVariables.PlayerVariables())).guiMessage) + "", 9, 94, -65536);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		ipAddress = new EditBox(this.font, this.leftPos + 8, this.topPos + 16, 120, 20, new TextComponent("IP Address")) {
			{
				setSuggestion("IP Address");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("IP Address");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("IP Address");
				else
					setSuggestion(null);
			}
		};
		VMCraftGUIMenu.guistate.put("text:ipAddress", ipAddress);
		ipAddress.setMaxLength(32767);
		this.addWidget(this.ipAddress);
		portNumber = new EditBox(this.font, this.leftPos + 133, this.topPos + 16, 120, 20, new TextComponent("Port Number")) {
			{
				setSuggestion("Port Number");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("Port Number");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("Port Number");
				else
					setSuggestion(null);
			}
		};
		VMCraftGUIMenu.guistate.put("text:portNumber", portNumber);
		portNumber.setMaxLength(32767);
		this.addWidget(this.portNumber);
		vmID = new EditBox(this.font, this.leftPos + 8, this.topPos + 40, 120, 20, new TextComponent("VM ID")) {
			{
				setSuggestion("VM ID");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("VM ID");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("VM ID");
				else
					setSuggestion(null);
			}
		};
		VMCraftGUIMenu.guistate.put("text:vmID", vmID);
		vmID.setMaxLength(32767);
		this.addWidget(this.vmID);
		vmName = new EditBox(this.font, this.leftPos + 133, this.topPos + 40, 120, 20, new TextComponent("VM Name")) {
			{
				setSuggestion("VM Name");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("VM Name");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("VM Name");
				else
					setSuggestion(null);
			}
		};
		VMCraftGUIMenu.guistate.put("text:vmName", vmName);
		vmName.setMaxLength(32767);
		this.addWidget(this.vmName);
		nodeName = new EditBox(this.font, this.leftPos + 8, this.topPos + 64, 120, 20, new TextComponent("Node Name")) {
			{
				setSuggestion("Node Name");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("Node Name");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("Node Name");
				else
					setSuggestion(null);
			}
		};
		VMCraftGUIMenu.guistate.put("text:nodeName", nodeName);
		nodeName.setMaxLength(32767);
		this.addWidget(this.nodeName);
		this.addRenderableWidget(new Button(this.leftPos + 135, this.topPos + 64, 56, 20, new TextComponent(" Save "), e -> {
			if (true) {
				VmcraftIiMod.PACKET_HANDLER.sendToServer(new VMCraftGUIButtonMessage(0, x, y, z));
				VMCraftGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 195, this.topPos + 64, 56, 20, new TextComponent(" Exit "), e -> {
			if (true) {
				VmcraftIiMod.PACKET_HANDLER.sendToServer(new VMCraftGUIButtonMessage(1, x, y, z));
				VMCraftGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
