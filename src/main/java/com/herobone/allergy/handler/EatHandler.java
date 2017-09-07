package com.herobone.allergy.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.herobone.allergy.capability.AllergyProvider;
import com.herobone.allergy.capability.IAllergy;
import com.herobone.allergy.util.RecipeUtil;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import squeek.applecore.api.food.FoodEvent;

public class EatHandler {
	
	@SubscribeEvent
	public void onFoodEaten(FoodEvent.FoodEaten event)
	{

		EntityPlayer player = event.player;
		IAllergy allergy = player.getCapability(AllergyProvider.ALLERGY_CAP, null);
		
		String thing = allergy.get();
		if (thing != null) {
			List<String> allergyList = new ArrayList<String>(Arrays.asList(thing.split(" ")));
			
			player.addChatMessage(new TextComponentString("Allergy!!"));
			
			for(int i = 0; i < allergyList.size(); i++) {
				String s = allergyList.get(i);
				if(s != null) {
					if (s == "gluten") {
						if (RecipeUtil.contains(RecipeUtil.getRecipe(event.food), new ItemStack(Items.WHEAT)) 
								|| RecipeUtil.contains(RecipeUtil.getRecipe(event.food), new ItemStack(Items.WHEAT_SEEDS)) 
								|| RecipeUtil.contains(event.food, Items.WHEAT)
								|| RecipeUtil.contains(event.food, Items.WHEAT_SEEDS)
								|| RecipeUtil.contains(new ItemStack(Items.WHEAT), event.food)
								|| RecipeUtil.contains(new ItemStack(Items.WHEAT_SEEDS), event.food)
								|| event.food.getItem() == Items.WHEAT
								|| event.food.getItem() == Items.WHEAT_SEEDS) {
							player.attackEntityFrom(DamageSource.generic, 5f);
							player.addChatMessage(new TextComponentString("Allergy!!"));
						} else {
							player.addChatMessage(new TextComponentString("No Allergy"));
						}
					}
					
					if (s == "fish") {
						if (RecipeUtil.contains(RecipeUtil.getRecipe(event.food), new ItemStack(Items.FISH)) 
								|| RecipeUtil.contains(event.food, Items.FISH)
								|| RecipeUtil.contains(new ItemStack(Items.FISH), event.food)
								|| event.food.getItem() == Items.FISH) {
							player.attackEntityFrom(DamageSource.generic, 5f);
							player.addChatMessage(new TextComponentString("Allergy!!"));
						} else {
							player.addChatMessage(new TextComponentString("No Allergy"));
						}
					}
					
					if (s == "egg") {
						if (RecipeUtil.contains(RecipeUtil.getRecipe(event.food), new ItemStack(Items.EGG)) 
								|| RecipeUtil.contains(event.food, Items.EGG)
								|| RecipeUtil.contains(new ItemStack(Items.EGG), event.food)
								|| event.food.getItem() == Items.EGG) {
							player.attackEntityFrom(DamageSource.generic, 5f);
							player.addChatMessage(new TextComponentString("Allergy!!"));
						} else {
							player.addChatMessage(new TextComponentString("No Allergy"));
						}
					}
				}
			}
		}
	}

}
