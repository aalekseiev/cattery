package com.murkino.domain.cat.breed;

import lombok.ToString;

@ToString
public class ScottishFoldLonghairs implements Breed {

	@Override
	public String shortName() {
		return "SFL";
	}
	
}
