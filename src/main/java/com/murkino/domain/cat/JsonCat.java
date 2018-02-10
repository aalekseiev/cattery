package com.murkino.domain.cat;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jcabi.aspects.Cacheable;
import com.murkino.domain.cat.color.Color;
import com.murkino.domain.cat.sex.Sex;

public final class JsonCat implements Cat {

	private final String json;
	
	private Cat origin;
	
	public JsonCat(String json) {
		this.json = json;
	}
	
	@Cacheable(forever = true)
	private Cat origin() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enableDefaultTyping();
		
		Map<String, Object> value;
		try {
			value = mapper.readValue(json, HashMap.class);
		} catch (Exception e) {
			throw new RuntimeException("Failed to deserialize Cat from JSON", e);
		}
//		origin = ;
		return origin;
	}

	@Override
	public void graduate() {
		origin().graduate();
	}

	@Override
	public void makeProduction() {
		origin().graduate();
	}

	@Override
	public void sell() {
		origin().sell();
	}

	@Override
	public void resetColor(Color color) {
		origin().resetColor(color);
	}

	@Override
	public void resetSex(Sex sex) {
		origin().resetSex(sex);
	}

	@Override
	public String toJson() throws JsonProcessingException {
		return origin().toJson();
	}

	@Override
	public void publish() {
		origin().publish();
	}

	@Override
	public Map<String, Object> toMedia() {
		return origin().toMedia();
	}
	
}
