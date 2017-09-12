package com.herobone.allergy.enums;

import net.minecraft.item.Item;
import net.minecraft.init.Items;

public enum EggEnum {
	CAKE(Items.CAKE);
	
	private Item item;
	
	private EggEnum(Item itemIn) {
		this.item = itemIn;
	}
	
	public Item getItem() {
		return this.item;
	}
	
	public static boolean contains(Item itemIn) {
		for (int i = 0; i < EggEnum.values().length; i++) {
			if (EggEnum.values()[i].getItem().equals(itemIn)) {
				return true;
			}
		}
		return false;
	}

}
