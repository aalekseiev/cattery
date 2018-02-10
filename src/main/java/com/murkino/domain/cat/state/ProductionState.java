package com.murkino.domain.cat.state;

import lombok.ToString;

@ToString
public class ProductionState extends State {

	@Override
	public String name() {
		return "production";
	}

}
