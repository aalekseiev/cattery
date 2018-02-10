package com.murkino.domain.cat.breed;

import lombok.ToString;

@ToString
public class ScottishStraight implements Breed {

	@Override
	public String shortName() {
		return "SCS";
	}

}
