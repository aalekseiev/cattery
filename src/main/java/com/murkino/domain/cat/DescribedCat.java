package com.murkino.domain.cat;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.DiscriminatorValue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.murkino.domain.cat.color.Color;
import com.murkino.domain.cat.sex.Sex;
import com.murkino.mapper.MurkinoObjectMapper;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor(force = true)
@DiscriminatorValue("DescribedCat")
public class DescribedCat implements Cat {

	private final Cat origin;
	
	private String description;

	public DescribedCat(Cat origin, String description) {
		super();
		this.origin = origin;
		this.description = description;
	}

	public void graduate() {
		origin.graduate();
	}

	public void makeProduction() {
		origin.makeProduction();
	}

	public void sell() {
		origin.sell();
	}

	public void resetColor(Color color) {
		origin.resetColor(color);
	}

	public void resetSex(Sex sex) {
		origin.resetSex(sex);
	}

	public String toJson() throws JsonProcessingException {
		ObjectMapper mapper = new MurkinoObjectMapper();
		Map<String, Object> map = new HashMap<>();
		map.put("entity", this);
		return mapper.writeValueAsString(map);
	}

	public void publish() {
		origin.publish();
	}

	public void hide() {
		origin.hide();
	}
	
	
}
