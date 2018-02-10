package com.murkino.domain.cat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.murkino.domain.cat.sex.Sex;

public interface Cat {

	void graduate();

	void makeProduction();

	void sell();
	
	void resetColor(String color);
	
	void resetSex(Sex sex);

	String toJson() throws JsonProcessingException;

	void publish();

}