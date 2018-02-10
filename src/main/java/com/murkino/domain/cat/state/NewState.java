package com.murkino.domain.cat.state;

import lombok.ToString;

@ToString
public final class NewState extends State {

	@Override
	public String name() {
		return "new";
	}

}
