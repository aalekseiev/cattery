package com.murkino.domain.cat.breed;

import lombok.ToString;

@ToString
public class ScottishFoldShorthairs implements Breed {

	@Override
	public String shortName() {
		return "SFS";
	}
	
}
