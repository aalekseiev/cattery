package com.murkino.domain.cat.breed;

import lombok.ToString;

@ToString
public class ScottishStraightLonghair implements Breed {

	@Override
	public String shortName() {
		return "SCL";
	}

}
