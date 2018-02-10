package com.murkino.domain.cat.breed;

public final class BreedsFactory {

	public Breed createByName(String name) throws Exception {
		Class<?> clazz = Class.forName("com.murkino.domain.breed." + name);
		return (Breed) clazz.newInstance();
	}
	
}
