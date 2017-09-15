package com.herobone.allergy.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.herobone.allergy.AllergyList;
import com.herobone.allergy.AllergyMod;
import com.herobone.allergy.capability.AllergyProvider;
import com.herobone.allergy.capability.BiomeCapProvider;
import com.herobone.allergy.capability.IAllergy;
import com.herobone.allergy.capability.IBiomeCap;
import com.herobone.allergy.capability.IIntolerance;
import com.herobone.allergy.capability.IntoleranceProvider;

import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class PlayerJoinHandler {
	
	public PlayerJoinHandler() {
		AllergyMod.LOGGER.info("Player Join Handler registered");
	}
	
	@SubscribeEvent
	public void eventI(PlayerLoggedInEvent event) {
		
		event.player.addChatMessage(new TextComponentString("Hello " + event.player.getDisplayNameString() + " your age is " + event.player.getAge()));
		
		IAllergy allergy = event.player.getCapability(AllergyProvider.ALLERGY_CAP, null);
		
		String in = allergy.get();
		
		if (allergy.get() == "null" || allergy.get() == null) {
			List<String> stringList = new ArrayList<String>();
			
			Random rand = new Random();	
			int  n = rand.nextInt(AllergyList.allergys.length);
			
			if (n > 0) {
				for (int i = 0; i < n; i++) {
					Random rand1 = new Random();
					int  n2 = rand1.nextInt(AllergyList.allergys.length);
					if (!stringList.contains(AllergyList.allergys[n2])) {
						stringList.add(AllergyList.allergys[n2]);
					} else {
						++n;
					}
				}
			}
			
			StringBuilder allergies = new StringBuilder();
			
			for(int i = 0; i < stringList.size(); i++) {
				String s = stringList.get(i);
				if(s != null) {
					allergies.append(s + " ");
				}
			}
			
			event.player.addChatComponentMessage(new TextComponentString("Your allergies are: " + allergies.toString())); //Directly from StringBuilder
			
			String sbout = allergies.toString(); //Convert StringBuilder to String
			allergy.set(sbout);
		} else {
			if (in != null) {
				List<String> allergyList = new ArrayList<>(Arrays.asList(allergy.get().split(" "))); //Do the ArrayList from the StringBuilder-String
				
				StringBuilder allergies = new StringBuilder();
				
				for(int i = 0; i < allergyList.size(); i++) {
					String s = allergyList.get(i);
					if(s != null) {
						allergies.append(s + " ");
					}
				}
				
				event.player.addChatComponentMessage(new TextComponentString("Your allergies are: " + allergies.toString())); //Directly from StringBuilder	
			}
		}
	}
	
	@SubscribeEvent
	public void eventII(PlayerLoggedInEvent event) {
		
		IIntolerance allergy = event.player.getCapability(IntoleranceProvider.INTOLERANCE_CAP, null);
		
		String in = allergy.get();
		
		if (allergy.get() == "null" || allergy.get() == null) {
			List<String> stringList = new ArrayList<String>();
			
			Random rand = new Random();	
			int  n = rand.nextInt(4);
			
			if (n > 0) {
				for (int i = 0; i < n; i++) {
					Random rand1 = new Random();
					int  n1 = rand1.nextInt(4);
					if (!stringList.contains(AllergyList.intolerances[n1])) {
						stringList.add(AllergyList.intolerances[n1]);
					} else {
						n++;
					}
				}
			}
			
			StringBuilder allergies = new StringBuilder();
			
			for(int i = 0; i < stringList.size(); i++) {
				String s = stringList.get(i);
				if(s != null) {
					allergies.append(s + " ");
				}
			}
			
			event.player.addChatComponentMessage(new TextComponentString("Your intolerances are: " + allergies.toString())); //Directly from StringBuilder
			
			String sbout = allergies.toString(); //Convert StringBuilder to String
			allergy.set(sbout);
		} else {
			if (in != null) {
				List<String> allergyList = new ArrayList<>(Arrays.asList(allergy.get().split(" "))); //Do the ArrayList from the StringBuilder-String
				
				StringBuilder allergies = new StringBuilder();
				
				for(int i = 0; i < allergyList.size(); i++) {
					String s = allergyList.get(i);
					if(s != null) {
						allergies.append(s + " ");
					}
				}
				
				event.player.addChatComponentMessage(new TextComponentString("Your intolerances are: " + allergies.toString())); //Directly from StringBuilder	
			}
		}
	}
	
	@SubscribeEvent
	public void eventIII(PlayerLoggedInEvent event) {
		
		IBiomeCap allergy = event.player.getCapability(BiomeCapProvider.BIOME_CAP, null);
		
		String in = allergy.get();
		
		if (allergy.get() == "null" || allergy.get() == null) {
			List<String> stringList = new ArrayList<String>();
			
			Random rand = new Random();	
			int  n = rand.nextInt(10);
			
			if (n > 0) {
				for (int i = 0; i < n; i++) {
					Random rand1 = new Random();
					int  n1 = rand1.nextInt(176);
					if (!stringList.contains(String.valueOf(n1))) {
						stringList.add(String.valueOf(n1));
					} else {
						n++;
					}
				}
			}
			
			StringBuilder allergies = new StringBuilder();
			
			for(int i = 0; i < stringList.size(); i++) {
				String s = stringList.get(i);
				if(s != null) {
					allergies.append(s + " ");
				}
			}
			
			event.player.addChatComponentMessage(new TextComponentString("Your biome allergies are: (ID is displayed) " + allergies.toString())); //Directly from StringBuilder
			
			String sbout = allergies.toString(); //Convert StringBuilder to String
			allergy.set(sbout);
		} else {
			if (in != null) {
				List<String> allergyList = new ArrayList<>(Arrays.asList(allergy.get().split(" "))); //Do the ArrayList from the StringBuilder-String
				
				StringBuilder allergies = new StringBuilder();
				
				for(int i = 0; i < allergyList.size(); i++) {
					String s = allergyList.get(i);
					if(s != null) {
						allergies.append(s + " ");
					}
				}
				
				event.player.addChatComponentMessage(new TextComponentString("Your biome allergies are: (ID is displayed) " + allergies.toString())); //Directly from StringBuilder	
			}
		}
	}
}
