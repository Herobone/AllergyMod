package com.herobone.allergy.capability;

public class Allergy implements IAllergy {
	
	private String list = null;

	@Override
	public void set(String list) {
		this.list = list;
	}

	@Override
	public String get() {
		return list;
	}

}
