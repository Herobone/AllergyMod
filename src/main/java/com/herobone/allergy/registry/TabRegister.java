package com.herobone.allergy.registry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class TabRegister extends CreativeTabs {

	public TabRegister() {
		super("allergy");
		this.setBackgroundImageName("item_search.png");
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(Blocks.PACKED_ICE);
	}
	
	@Override
	public boolean hasSearchBar() {
		return true;
	}

}
