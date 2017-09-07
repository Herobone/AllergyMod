package com.herobone.allergy.handler;

import com.herobone.allergy.AllergyMod;
import com.herobone.allergy.capability.AllergyProvider;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandler {
	
	 public static final ResourceLocation ALLERGY_CAP = new ResourceLocation(AllergyMod.MODID, "allergy");

	 
	@SuppressWarnings("deprecation")
	@SubscribeEvent
	public void attachCapability(AttachCapabilitiesEvent.Entity event) {

		if (!(event.getEntity() instanceof EntityPlayer)) return;
		event.addCapability(ALLERGY_CAP, new AllergyProvider());

	}

}
