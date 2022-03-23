
package net.mcreator.vmcraft_ii.item;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.vmcraft_ii.init.VmcraftIiModTabs;

public class ConfigurationKeyItem extends Item {
	public ConfigurationKeyItem() {
		super(new Item.Properties().tab(VmcraftIiModTabs.TAB_VM_CRAFT).stacksTo(64).rarity(Rarity.COMMON));
		setRegistryName("configuration_key");
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

	@Override
	public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
		return 0.9F;
	}
}
