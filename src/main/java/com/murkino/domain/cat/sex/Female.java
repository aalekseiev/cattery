package com.murkino.domain.cat.sex;

import lombok.ToString;

@ToString
public final class Female extends Sex {

	@Override
	public String shortName() {
		return "F";
	}

}
