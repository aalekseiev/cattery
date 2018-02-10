package com.murkino.domain.cat.breed;

import lombok.ToString;

@ToString
public class BritishLonghairs implements Breed {

	@Override
	public String shortName() {
		return "BRL";
	}

}
