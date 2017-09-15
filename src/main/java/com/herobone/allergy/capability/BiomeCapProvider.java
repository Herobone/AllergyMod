package com.herobone.allergy.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class BiomeCapProvider implements ICapabilitySerializable<NBTBase> {
	
	 @CapabilityInject(IBiomeCap.class)
	 public static final Capability<IBiomeCap> BIOME_CAP = null;
	 
	 private IBiomeCap instance = BIOME_CAP.getDefaultInstance();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == BIOME_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == BIOME_CAP ? BIOME_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return BIOME_CAP.getStorage().writeNBT(BIOME_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		BIOME_CAP.getStorage().readNBT(BIOME_CAP, this.instance, null, nbt);
	}

}
