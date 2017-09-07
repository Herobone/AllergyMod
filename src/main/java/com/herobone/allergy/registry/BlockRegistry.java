package com.herobone.allergy.registry;

import com.herobone.allergy.AllergyMod;
import com.herobone.allergy.blocks.*;
import com.herobone.allergy.util.NameUtils;

import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockRegistry {

	/** public static Block block; */
	public static Block microscope;

	/**
	*	block = new Block().setCreativeTab(AllergyMod.instance.tab);<br>
	*	NameUtils.setNames(block, "block");
	*/
	public void init() {
		microscope = new Microscope().setCreativeTab(AllergyMod.instance.tab);
		NameUtils.setNames(microscope, "microscope");
	}
	/** registerBlocks(block); */
	public void register() {
		
		registerBlocks(microscope);
		
	}
	
	private void registerBlocks(Block block) {
		GameRegistry.register(block);
		ItemBlock itemblock = new ItemBlock(block);
		itemblock.setUnlocalizedName(block.getUnlocalizedName()).setRegistryName(block.getRegistryName());
		GameRegistry.register(itemblock);
	}

}
