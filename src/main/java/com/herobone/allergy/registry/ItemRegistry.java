package com.herobone.allergy.registry;

import com.herobone.allergy.AllergyMod;
import com.herobone.allergy.item.AllergyPills;
import com.herobone.allergy.util.NameUtils;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemRegistry {
	
	/** public static Item item; */
	public static Item pills;

	/**
	* item = new ItemClass().setCreativeTab(HeroUtils.instance.tab);<br>
	* NameUtils.setNames(item, "item");
	*/
	public void init() {
		pills = new AllergyPills().setCreativeTab(AllergyMod.instance.tab);
		NameUtils.setNames(pills, "pill");
	}
	/** registerItem(item); */
	public void register() {
		registerItem(pills);
	}
	
	private void registerItem(Item item) {
		GameRegistry.register(item);
	}
	
}
