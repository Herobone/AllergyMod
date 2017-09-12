package com.herobone.allergy.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class RecipeUtil {
	
	private static ArrayList<IRecipe> recipes = (ArrayList<IRecipe>) CraftingManager.getInstance().getRecipeList();
	
	/**
	 * Get Recipe for Item.
	 * CRAFTING ONLY
	 * @param in (ItemStack) output of Recipe
	 * @return (IRecipe) Recipe for in
	 */
	
	public static IRecipe getRecipe(ItemStack in) {
		Iterator<IRecipe> iterator = recipes.iterator();
		
		while(iterator.hasNext()) {
			IRecipe tmpRecipe = iterator.next();
			if (tmpRecipe instanceof ShapedOreRecipe || tmpRecipe instanceof ShapedRecipes || tmpRecipe instanceof ShapelessOreRecipe || tmpRecipe instanceof ShapelessRecipes) {
				if (tmpRecipe.getRecipeOutput().getItem() == in.getItem()) {
					return tmpRecipe;
				}
			}
		}
			
		return null;
	}
	
	/**
	 * Crafting ONLY
	 * @param recipeIn (IRecipe) Recipe that may contain itemIn
	 * @param itemIn (ItemStack) Item that may be contained in Recipe
	 * @return (boolean) true if contained false if not
	 */
	
	public static boolean contains(IRecipe recipeIn, ItemStack itemIn) {
		if (recipeIn != null) {
			Iterator<IRecipe> iterator = recipes.iterator();
			
			while(iterator.hasNext()) {
				IRecipe tmpRecipe = iterator.next();
				
				if(tmpRecipe instanceof ShapedRecipes) {
					ShapedRecipes test = (ShapedRecipes) tmpRecipe;
					if (tmpRecipe == recipeIn) {
						for(int i = 0; i < test.recipeItems.length; i++) {
							if(test.recipeItems[i] != null) {
								if (test.recipeItems[i].isItemEqual(itemIn)) {
									return true;
								}
							}
						}
					}
				} else if(tmpRecipe instanceof ShapelessRecipes) {
					ShapelessRecipes test = (ShapelessRecipes) tmpRecipe;
					if (tmpRecipe == recipeIn) {
						for(int i = 0; i < test.recipeItems.size(); i++) {
							if(test.recipeItems.get(i) != null) {
								if (test.recipeItems.get(i).isItemEqual(itemIn)) {
									return true;
								}
							}
						}
					}
				} else if(tmpRecipe instanceof ShapedOreRecipe) {
					ShapedOreRecipe test = (ShapedOreRecipe) tmpRecipe;
					Object[] testIn = test.getInput();
					for(int i = 0; i < testIn.length; i++) {
						if(testIn[i] instanceof ItemStack) {
							ItemStack testItem = (ItemStack)testIn[i];
							if (testItem.isItemEqual(itemIn)) {
								return true;
							}
						}
					}
				} else if(tmpRecipe instanceof ShapelessOreRecipe) {
					ShapelessOreRecipe test = (ShapelessOreRecipe) tmpRecipe;
					ArrayList<Object> testIn = test.getInput();
					for(int i = 0; i < testIn.size(); i++) {
						if(testIn.get(i) instanceof ItemStack) {
							ItemStack testItem = (ItemStack) testIn.get(i);
							if (testItem.isItemEqual(itemIn)) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	/** 
	 * Furnace only! 
	 * @param itemIn item that should be checked if is contained 
	 * @param itemOut item that should come out of recipe 
	 **/
	public static boolean contains(ItemStack itemIn, ItemStack itemOut) {
		Iterator<Entry<ItemStack, ItemStack>> it = FurnaceRecipes.instance().getSmeltingList().entrySet().iterator();
		
		while(it.hasNext()) {
			Entry<ItemStack,ItemStack> entry = it.next();
			ItemStack input = entry.getKey();
			ItemStack output = entry.getValue();
			
			if (itemIn.getItem() == input.getItem() && itemOut.getItem() == output.getItem()) {
				return true;
			} else {
				continue;
			}
		}
		
		return false;
	}
	
	/**
	 * Furnace only. Checks the recipe behind the SmeltingRecipe
	 * @param itemOutput (ItemStack) output of the furnace
	 * @param contained (Item) Item that has maybe been used in crafting before
	 * @return (boolean) true if contained false if not
	 */
	
	public static boolean contains(ItemStack itemOutput, Item contained) {
		Iterator<Entry<ItemStack, ItemStack>> it = FurnaceRecipes.instance().getSmeltingList().entrySet().iterator();
		
		while(it.hasNext()) {
			Entry<ItemStack,ItemStack> entry = it.next();
			ItemStack input = entry.getKey();
			ItemStack output = entry.getValue();
			
			if (itemOutput.getItem() == output.getItem()) {
				IRecipe recipe = getRecipe(input);
				if (recipe != null) {
					boolean contains = contains(recipe, input);
					if (contains) {
						return contains;
					} else {
						continue;
					}
				}
			} else {
				continue;
			}
		}
		
		return false;
	}

}
