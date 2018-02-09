package com.murkino.domain.cat.sex;

import com.fasterxml.jackson.annotation.JsonGetter;

public abstract class Sex {

	@JsonGetter("shortName")
	public abstract String shortName();
	
}
