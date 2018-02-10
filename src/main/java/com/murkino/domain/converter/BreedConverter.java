package com.murkino.domain.converter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.murkino.domain.cat.breed.Breed;
import com.murkino.domain.cat.breed.BreedsFactory;
import com.murkino.domain.cat.state.State;
import com.murkino.domain.cat.state.StatesFactory;

@Converter(autoApply = true)
public class BreedConverter implements AttributeConverter<Breed, String> {

	private static final Map<String, Breed> states = new ConcurrentHashMap<>();
	
	private final BreedsFactory factory = new BreedsFactory();

	@Override
	public String convertToDatabaseColumn(Breed attribute) {
		if (attribute == null) {
			return null;
		}
		return attribute.getClass().getSimpleName();
	}

	@Override
	public Breed convertToEntityAttribute(String dbData) {
		if (dbData == null) {
			return null;
		}
		Breed breed = states.get(dbData);
		if (breed == null) {
			try {
				breed = factory.createByName(dbData);
				states.putIfAbsent(dbData, breed);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return breed;
	}

}

