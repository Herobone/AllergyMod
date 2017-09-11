package com.herobone.allergy.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.herobone.allergy.AllergyList;
import com.herobone.allergy.capability.AllergyProvider;
import com.herobone.allergy.capability.IAllergy;

import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class PlayerJoinHandler {
	
	@SubscribeEvent
	public void event(PlayerLoggedInEvent event) {
		
		event.player.addChatMessage(new TextComponentString("Hello " + event.player.getDisplayNameString() + " your age is " + event.player.getAge()));
		
		IAllergy allergy = event.player.getCapability(AllergyProvider.ALLERGY_CAP, null);
		
		String in = allergy.get();
		
		if (allergy.get() == "null" || allergy.get() == null) {
			List<String> stringList = new ArrayList<String>();
			
			Random rand = new Random();	
			int  n = rand.nextInt(4);
			
			if (n > 0) {
				for (int i = 0; i < n; i++) {
					Random rand1 = new Random();
					int  n1 = rand1.nextInt(4);
					stringList.add(AllergyList.allergys[n1]);
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
}
