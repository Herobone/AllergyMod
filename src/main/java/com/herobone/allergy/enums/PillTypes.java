package com.herobone.allergy.enums;

import net.minecraft.util.IStringSerializable;

public enum PillTypes implements IStringSerializable {
	GLUTEN("gluten", 0),
	EGG("egg", 1),
	FISH("fish", 2),
	LACTOSE("lactase", 3);
	
	private int ID;
	private String name;
	
	private PillTypes(String name, int ID) {
		this.ID = ID;
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}
	
	public int getID() {
		return ID;
	}
	
	@Override
	public String toString() {
		return getName();
	}

}
