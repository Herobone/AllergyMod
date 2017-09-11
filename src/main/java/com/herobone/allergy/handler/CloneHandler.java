package com.herobone.allergy.handler;

import com.herobone.allergy.capability.AllergyProvider;
import com.herobone.allergy.capability.IAllergy;
import com.herobone.allergy.capability.IIntolerance;
import com.herobone.allergy.capability.IntoleranceProvider;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CloneHandler {
	
	@SubscribeEvent
	public void onPlayerClone(PlayerEvent.Clone event) {
		EntityPlayer player = event.getEntityPlayer();
		IAllergy allergy = player.getCapability(AllergyProvider.ALLERGY_CAP, null);
		IAllergy oldAlllergy = event.getOriginal().getCapability(AllergyProvider.ALLERGY_CAP, null);
		
		allergy.set(oldAlllergy.get());
		
		IIntolerance intolerance = player.getCapability(IntoleranceProvider.INTOLERANCE_CAP, null);
		IIntolerance oldIntolerance = event.getOriginal().getCapability(IntoleranceProvider.INTOLERANCE_CAP, null);
		
		intolerance.set(oldIntolerance.get());
	}

}
