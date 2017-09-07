package com.herobone.allergy.proxy;

import com.herobone.allergy.AllergyMod;
import com.herobone.allergy.enums.PillTypes;
import com.herobone.allergy.registry.BlockRegistry;
import com.herobone.allergy.registry.ItemRegistry;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
	private String inv = "inventory";
	/**
	* registerModel(BlockRegistry.block, 0, new ModelResourceLocation(BlockRegistry.block.getRegistryName(), inv));
	* registerModel(ItemRegistry.item, 0, new ModelResourceLocation(ItemRegistry.item.getRegistryName(), inv));
	*/
	public void registerModels() {
		registerModel(BlockRegistry.microscope, 0, new ModelResourceLocation(BlockRegistry.microscope.getRegistryName(), inv));
		
		for (int i = 0; i < PillTypes.values().length; i++) {
			registerModel(ItemRegistry.pills, i, new ModelResourceLocation(AllergyMod.MODID + ":pill_" + PillTypes.values()[i].getName(), inv));
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void init() {
	}

	private void registerModel(Object obj, int meta, ModelResourceLocation loc) {
		Item item = null;
		
		if (obj instanceof Item) {
			item = (Item) obj;
		} else if (obj instanceof Block) {
			item = Item.getItemFromBlock((Block)obj);
		} else {
			throw new IllegalArgumentException();
		}
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, loc);
	}
	
	@Override
	public void registerModelBakeryVariants() {
		ModelBakery.registerItemVariants(ItemRegistry.pills, new ResourceLocation(AllergyMod.MODID, "pill_gluten"), new ResourceLocation(AllergyMod.MODID, "pill_egg"), new ResourceLocation(AllergyMod.MODID, "pill_fish"), new ResourceLocation(AllergyMod.MODID, "pill_lactase"));
	}
}
