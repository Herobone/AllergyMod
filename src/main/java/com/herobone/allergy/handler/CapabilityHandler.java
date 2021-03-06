package com.herobone.allergy.handler;

import com.herobone.allergy.AllergyMod;
import com.herobone.allergy.capability.AllergyProvider;
import com.herobone.allergy.capability.BiomeCapProvider;
import com.herobone.allergy.capability.IntoleranceProvider;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandler {
	
	public static final ResourceLocation ALLERGY_CAP = new ResourceLocation(AllergyMod.MODID, "allergy");
	public static final ResourceLocation INTOLERANCE_CAP = new ResourceLocation(AllergyMod.MODID, "intolerance");
	public static final ResourceLocation BIOME_CAP = new ResourceLocation(AllergyMod.MODID, "biome");

	public CapabilityHandler() {
		AllergyMod.LOGGER.info("Capability Handler registered");
	}
	
	@SuppressWarnings("deprecation")
	@SubscribeEvent
	public void attachCapability(AttachCapabilitiesEvent.Entity event) {

		if (!(event.getEntity() instanceof EntityPlayer)) return;
		event.addCapability(ALLERGY_CAP, new AllergyProvider());

	}
	
	@SuppressWarnings("deprecation")
	@SubscribeEvent
	public void attachCapabilityIntolerance(AttachCapabilitiesEvent.Entity event) {

		if (!(event.getEntity() instanceof EntityPlayer)) return;
		event.addCapability(INTOLERANCE_CAP, new IntoleranceProvider());

	}
	
	@SuppressWarnings("deprecation")
	@SubscribeEvent
	public void attachCapabilityBiome(AttachCapabilitiesEvent.Entity event) {

		if (!(event.getEntity() instanceof EntityPlayer)) return;
		event.addCapability(BIOME_CAP, new BiomeCapProvider());

	}

}
