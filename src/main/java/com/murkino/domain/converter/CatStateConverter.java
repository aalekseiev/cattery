package com.murkino.domain.converter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.murkino.domain.cat.state.State;
import com.murkino.domain.cat.state.StatesFactory;

@Converter(autoApply = true)
public class CatStateConverter implements AttributeConverter<State, String> {

	private static final Map<String, State> states = new ConcurrentHashMap<>();
	
	private final StatesFactory factory = new StatesFactory();

	@Override
	public String convertToDatabaseColumn(State attribute) {
		if (attribute == null) {
			return null;
		}
		return attribute.getClass().getSimpleName();
	}

	@Override
	public State convertToEntityAttribute(String dbData) {
		if (dbData == null) {
			return null;
		}
		State state = states.get(dbData);
		if (state == null) {
			try {
				state = factory.createByName(dbData);
				states.putIfAbsent(dbData, state);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return state;
	}

}

