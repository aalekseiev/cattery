package com.murkino.domain.cat.sex;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public abstract class Sex {

//	@JsonGetter("shortName")
//	@JsonProperty
	public abstract String shortName();
	
}
