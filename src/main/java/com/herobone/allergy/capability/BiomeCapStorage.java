package com.herobone.allergy.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class BiomeCapStorage implements IStorage<IBiomeCap> {

	@Override
	public NBTBase writeNBT(Capability<IBiomeCap> capability, IBiomeCap instance, EnumFacing side) {
		return new NBTTagString(instance.get());
	}

	@Override
	public void readNBT(Capability<IBiomeCap> capability, IBiomeCap instance, EnumFacing side, NBTBase nbt) {
		instance.set(((NBTTagString) nbt).getString());
	}

}
