package com.herobone.allergy.capability;

public class BiomeCap implements IBiomeCap {
	
	private String list = "null";

	@Override
	public void set(String list) {
		this.list = list;
	}

	@Override
	public String get() {
		return list;
	}

}
