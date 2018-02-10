package com.murkino.domain.cat.color;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor(force = true)
public class CatColor implements Color {

	@JsonProperty
	private final String value;

	public CatColor(String value) {
		super();
		this.value = value;
	}
	
	public String value() {
		return value;
	}
	
}
