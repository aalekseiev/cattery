package com.murkino.domain.cat.breed;

import lombok.ToString;

@ToString
public class BritishShorthairs implements Breed {

	@Override
	public String shortName() {
		return "BRI";
	}

}
