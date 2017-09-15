package com.herobone.allergy.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.herobone.allergy.AllergyMod;
import com.herobone.allergy.capability.AllergyProvider;
import com.herobone.allergy.capability.BiomeCapProvider;
import com.herobone.allergy.capability.IAllergy;
import com.herobone.allergy.capability.IBiomeCap;
import com.herobone.allergy.util.AllergyHelpers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class UpdateHandler {
	
	public UpdateHandler() {
		AllergyMod.LOGGER.info("Update Handler registered");
	}
	
	@SubscribeEvent
	public void playerInventoryUpdateEvent(LivingEvent.LivingUpdateEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
			InventoryPlayer inv = player.inventory;
			IAllergy allergy = player.getCapability(AllergyProvider.ALLERGY_CAP, null);
			
			String thing = allergy.get();
			if (thing != null) {
				List<String> allergyList = new ArrayList<String>(Arrays.asList(thing.split(" ")));
				
				for(int i = 0; i < allergyList.size(); i++) {
					String s = allergyList.get(i);
					if(s != null) {
						if (s.equals("diamond")) {
							if (AllergyHelpers.diamond(inv)) {
								player.addPotionEffect(new PotionEffect(MobEffects.POISON, 21, 3));
							}
						} else if (s.equals("gold")) {
							if (AllergyHelpers.gold(inv)) {
								player.addPotionEffect(new PotionEffect(MobEffects.POISON, 21, 3));
							}
						} else if (s.equals("iron")) {
							if (AllergyHelpers.iron(inv)) {
								player.addPotionEffect(new PotionEffect(MobEffects.POISON, 21, 3));
							}
						} else if (s.equals("obsidian")) {
							if (AllergyHelpers.obsidian(inv)) {
								player.addPotionEffect(new PotionEffect(MobEffects.POISON, 21, 3));
							}
						}
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void playerBiomeUpdateEvent(LivingEvent.LivingUpdateEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
			BlockPos pos = player.getPosition();
			IBiomeCap allergy = player.getCapability(BiomeCapProvider.BIOME_CAP, null);
			
			String thing = allergy.get();
			if (thing != null) {
				List<String> allergyList = new ArrayList<String>(Arrays.asList(thing.split(" ")));
				Biome biome = player.worldObj.getBiome(pos);
				
				for(int i = 0; i < allergyList.size(); i++) {
					if (allergyList.get(i) != "null") {
					int s = Integer.parseInt(allergyList.get(i));
					if (Biome.getIdForBiome(biome) == s) {
						player.addPotionEffect(new PotionEffect(MobEffects.POISON, 21, 3));
					}
					}
				}
			}
		}
	}

}
