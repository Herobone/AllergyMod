package com.herobone.allergy.util;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class AllergyHelpers {
	
	/**
	 * Returns if Inventory contains things made from diamond
	 * @param inv Inventory of a player
	 * @return Inventory contains things made from diamond
	 */
	public static boolean diamond(InventoryPlayer inv) {
		return inv.hasItemStack(new ItemStack(Blocks.DIAMOND_BLOCK))
		|| inv.hasItemStack(new ItemStack(Blocks.DIAMOND_ORE))
		|| inv.hasItemStack(new ItemStack(Items.DIAMOND))
		|| inv.hasItemStack(new ItemStack(Items.DIAMOND_AXE))
		|| inv.hasItemStack(new ItemStack(Items.DIAMOND_HOE))
		|| inv.hasItemStack(new ItemStack(Items.DIAMOND_HORSE_ARMOR))
		|| inv.hasItemStack(new ItemStack(Items.DIAMOND_PICKAXE))
		|| inv.hasItemStack(new ItemStack(Items.DIAMOND_SHOVEL))
		|| inv.hasItemStack(new ItemStack(Items.DIAMOND_SWORD))
		|| inv.hasItemStack(new ItemStack(Items.DIAMOND_BOOTS))
		|| inv.hasItemStack(new ItemStack(Items.DIAMOND_CHESTPLATE))
		|| inv.hasItemStack(new ItemStack(Items.DIAMOND_HELMET))
		|| inv.hasItemStack(new ItemStack(Items.DIAMOND_LEGGINGS));
	}
	
	
	/**
	 * Returns if Inventory contains things made from gold
	 * @param inv Inventory of a player
	 * @return Inventory contains things made from gold
	 */
	public static boolean gold(InventoryPlayer inv) {
		return inv.hasItemStack(new ItemStack(Blocks.GOLD_BLOCK))
		|| inv.hasItemStack(new ItemStack(Blocks.GOLD_ORE))
		|| inv.hasItemStack(new ItemStack(Items.GOLD_INGOT))
		|| inv.hasItemStack(new ItemStack(Items.GOLDEN_AXE))
		|| inv.hasItemStack(new ItemStack(Items.GOLDEN_HOE))
		|| inv.hasItemStack(new ItemStack(Items.GOLDEN_HORSE_ARMOR))
		|| inv.hasItemStack(new ItemStack(Items.GOLDEN_PICKAXE))
		|| inv.hasItemStack(new ItemStack(Items.GOLDEN_SHOVEL))
		|| inv.hasItemStack(new ItemStack(Items.GOLDEN_SWORD))
		|| inv.hasItemStack(new ItemStack(Items.GOLDEN_BOOTS))
		|| inv.hasItemStack(new ItemStack(Items.GOLDEN_CHESTPLATE))
		|| inv.hasItemStack(new ItemStack(Items.GOLDEN_HELMET))
		|| inv.hasItemStack(new ItemStack(Items.GOLDEN_LEGGINGS))
		|| inv.hasItemStack(new ItemStack(Items.GOLD_NUGGET))
		|| inv.hasItemStack(new ItemStack(Items.GOLDEN_APPLE))
		|| inv.hasItemStack(new ItemStack(Items.GOLDEN_CARROT));
	}
	
	/**
	 * Returns if Inventory contains things made from iron
	 * @param inv Inventory of a player
	 * @return Inventory contains things made from iron
	 */
	public static boolean iron(InventoryPlayer inv) {
		return inv.hasItemStack(new ItemStack(Blocks.IRON_BLOCK))
		|| inv.hasItemStack(new ItemStack(Blocks.IRON_ORE))
		|| inv.hasItemStack(new ItemStack(Items.IRON_INGOT))
		|| inv.hasItemStack(new ItemStack(Items.IRON_AXE))
		|| inv.hasItemStack(new ItemStack(Items.IRON_HOE))
		|| inv.hasItemStack(new ItemStack(Items.IRON_HORSE_ARMOR))
		|| inv.hasItemStack(new ItemStack(Items.IRON_PICKAXE))
		|| inv.hasItemStack(new ItemStack(Items.IRON_SHOVEL))
		|| inv.hasItemStack(new ItemStack(Items.IRON_SWORD))
		|| inv.hasItemStack(new ItemStack(Items.IRON_BOOTS))
		|| inv.hasItemStack(new ItemStack(Items.IRON_CHESTPLATE))
		|| inv.hasItemStack(new ItemStack(Items.IRON_HELMET))
		|| inv.hasItemStack(new ItemStack(Items.IRON_LEGGINGS));
	}
	
	/**
	 * Returns if Inventory contains things made from obsidian
	 * @param inv Inventory of a player
	 * @return Inventory contains things made from obsidian
	 */
	public static boolean obsidian(InventoryPlayer inv) {
		return inv.hasItemStack(new ItemStack(Blocks.OBSIDIAN));
	}

}
