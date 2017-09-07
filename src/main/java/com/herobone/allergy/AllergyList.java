package com.herobone.allergy;

import java.util.HashMap;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;

public class AllergyList {
	
	public static final String[] allergys = {"gluten", "egg", "fish", "lactose"};
	
	public static final String[] intolerances = {"gluten", "egg", "fish", "lactose"};
	
	public static final HashMap<EntityPlayer, List<String>> playerAllergies = new HashMap<>();
}
