package com.murkino.domain.cat;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface Cat {

	Cat graduate();

	Cat makeProduction();

	Cat sell();
	
	Cat resetColor(String color);

	String toJson() throws JsonProcessingException;

	Cat publish();

}