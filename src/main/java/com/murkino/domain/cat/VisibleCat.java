package com.murkino.domain.cat;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.murkino.domain.cat.color.Color;
import com.murkino.domain.cat.sex.Sex;
import com.murkino.mapper.MurkinoObjectMapper;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor(force = true)
public final class VisibleCat implements Cat {

	@JsonProperty
	private final Cat origin;
	
	private Boolean visible;

	public VisibleCat(Cat origin, Boolean visible) {
		this.origin = origin;
		this.visible = visible;
	}

	@Override
	public void graduate() {
		origin.graduate();
	}

	@Override
	public void makeProduction() {
		origin.makeProduction();
	}

	@Override
	public void sell() {
		origin.sell();
	}

	@Override
	public void hide() {
		visible = false;
	}
	
	@Override
	public void publish() {
		this.visible = true;
	}

	
	@Override
	public void resetColor(Color color) {
		origin.resetColor(color);
	}

	public Boolean visible() {
		return this.visible;
	}
	
	@Override
	public String toJson() throws JsonProcessingException {
		ObjectMapper mapper = new MurkinoObjectMapper();
		
        Map<String, Object> map = new HashMap<>();
        map.put("entity", this);
        return mapper.writeValueAsString(map);
	}

	@Override
	public void resetSex(Sex sex) {
		origin.resetSex(sex);
	}
	
	public String id() {
		return origin.id();
	}

}
