package com.herobone.allergy.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class AllergyProvider implements ICapabilitySerializable<NBTBase> {
	
	 @CapabilityInject(IAllergy.class)
	 public static final Capability<IAllergy> ALLERGY_CAP = null;
	 
	 private IAllergy instance = ALLERGY_CAP.getDefaultInstance();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == ALLERGY_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == ALLERGY_CAP ? ALLERGY_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return ALLERGY_CAP.getStorage().writeNBT(ALLERGY_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		ALLERGY_CAP.getStorage().readNBT(ALLERGY_CAP, this.instance, null, nbt);
	}

}
