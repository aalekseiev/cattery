package com.murkino.domain.cat.breed;

import com.fasterxml.jackson.annotation.JsonGetter;

public interface Breed {

	@JsonGetter("shortName")
	String shortName();
	
}
