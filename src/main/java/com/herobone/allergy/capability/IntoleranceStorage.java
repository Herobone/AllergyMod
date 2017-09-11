package com.herobone.allergy.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class IntoleranceStorage implements IStorage<IIntolerance> {

	@Override
	public NBTBase writeNBT(Capability<IIntolerance> capability, IIntolerance instance, EnumFacing side) {
		return new NBTTagString(instance.get());
	}

	@Override
	public void readNBT(Capability<IIntolerance> capability, IIntolerance instance, EnumFacing side, NBTBase nbt) {
		instance.set(((NBTTagString) nbt).getString());
	}

}
