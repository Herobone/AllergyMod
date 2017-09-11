package com.herobone.allergy.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class IntoleranceProvider implements ICapabilitySerializable<NBTBase> {
	
	 @CapabilityInject(IIntolerance.class)
	 public static final Capability<IIntolerance> INTOLERANCE_CAP = null;
	 
	 private IIntolerance instance = INTOLERANCE_CAP.getDefaultInstance();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == INTOLERANCE_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == INTOLERANCE_CAP ? INTOLERANCE_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return INTOLERANCE_CAP.getStorage().writeNBT(INTOLERANCE_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		INTOLERANCE_CAP.getStorage().readNBT(INTOLERANCE_CAP, this.instance, null, nbt);
	}

}
