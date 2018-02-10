package com.murkino.domain.cat.sex;

import lombok.ToString;

@ToString
public final class Male extends Sex {

	@Override
	public String shortName() {
		return "M";
	}

}
