package com.murkino.domain.cat.state;

import com.fasterxml.jackson.annotation.JsonGetter;

public abstract class State {

//	@JsonGetter("shortName")
	public abstract String name();
	
}
