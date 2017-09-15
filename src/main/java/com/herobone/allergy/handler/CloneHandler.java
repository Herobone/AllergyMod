package com.herobone.allergy.handler;

import com.herobone.allergy.AllergyMod;
import com.herobone.allergy.capability.AllergyProvider;
import com.herobone.allergy.capability.BiomeCapProvider;
import com.herobone.allergy.capability.IAllergy;
import com.herobone.allergy.capability.IIntolerance;
import com.herobone.allergy.capability.IBiomeCap;
import com.herobone.allergy.capability.IntoleranceProvider;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CloneHandler {
	
	public CloneHandler() {
		AllergyMod.LOGGER.info("Clone Handler registered");
	}
	
	@SubscribeEvent
	public void onPlayerClone(PlayerEvent.Clone event) {
		EntityPlayer player = event.getEntityPlayer();
		IAllergy allergy = player.getCapability(AllergyProvider.ALLERGY_CAP, null);
		IAllergy oldAlllergy = event.getOriginal().getCapability(AllergyProvider.ALLERGY_CAP, null);
		
		allergy.set(oldAlllergy.get());
		
		IIntolerance intolerance = player.getCapability(IntoleranceProvider.INTOLERANCE_CAP, null);
		IIntolerance oldIntolerance = event.getOriginal().getCapability(IntoleranceProvider.INTOLERANCE_CAP, null);
		
		intolerance.set(oldIntolerance.get());
		
		IBiomeCap biome = player.getCapability(BiomeCapProvider.BIOME_CAP, null);
		IBiomeCap oldBiome = event.getOriginal().getCapability(BiomeCapProvider.BIOME_CAP, null);
		
		biome.set(oldBiome.get());
	}

}
