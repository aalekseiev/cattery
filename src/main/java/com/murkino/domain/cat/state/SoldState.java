package com.murkino.domain.cat.state;

import lombok.ToString;

@ToString
public class SoldState extends State {

	@Override
	public String name() {
		return "sold";
	}

}
