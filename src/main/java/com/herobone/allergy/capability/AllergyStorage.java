package com.herobone.allergy.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class AllergyStorage implements IStorage<IAllergy> {

	@Override
	public NBTBase writeNBT(Capability<IAllergy> capability, IAllergy instance, EnumFacing side) {
		return new NBTTagString(instance.get());
	}

	@Override
	public void readNBT(Capability<IAllergy> capability, IAllergy instance, EnumFacing side, NBTBase nbt) {
		instance.set(((NBTTagString) nbt).getString());
	}

}
