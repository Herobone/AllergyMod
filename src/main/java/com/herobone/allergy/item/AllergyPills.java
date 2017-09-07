package com.herobone.allergy.item;

import java.util.List;

import com.herobone.allergy.enums.PillTypes;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class AllergyPills extends Item {
	
	public AllergyPills() {
		this.setHasSubtypes(true);
	}
	
	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
		for(int i = 0; i < PillTypes.values().length; i++) {
			subItems.add(new ItemStack(itemIn, 1, i));
		}
	}
	
	/**
	 * Gets the correct unlocalized name using the {@link ChipTypes} enum
	 */
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		for(int i = 0; i < PillTypes.values().length; i++) {
			if(stack.getItemDamage() == i) {
				return this.getUnlocalizedName() + "." + PillTypes.values()[i].getName();
			}
			else {
				continue;
			}
		}
		return this.getUnlocalizedName() + "." + PillTypes.GLUTEN.getName();
	}

}
