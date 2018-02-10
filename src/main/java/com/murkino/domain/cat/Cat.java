package com.murkino.domain.cat;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.murkino.domain.cat.color.Color;
import com.murkino.domain.cat.sex.Sex;

public interface Cat {

	void graduate();

	void makeProduction();

	void sell();
	
	void resetColor(Color color);
	
	void resetSex(Sex sex);

	String toJson() throws JsonProcessingException;
	
	Map<String, Object> toMedia();

	void publish();

}