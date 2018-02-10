package com.murkino.domain.cat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.murkino.domain.cat.color.Color;
import com.murkino.domain.cat.sex.Sex;

public interface Cat {

	String id();
	
	void graduate();

	void makeProduction();

	void sell();
	
	void resetColor(Color color);
	
	void resetSex(Sex sex);

	String toJson() throws JsonProcessingException;

	void publish();
	
	void hide();

}