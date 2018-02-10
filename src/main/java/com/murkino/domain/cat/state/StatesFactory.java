package com.murkino.domain.cat.state;

public final class StatesFactory {

	public State createByName(String name) throws Exception {
		Class<?> clazz = Class.forName("com.murkino.domain.state." + name);
		return (State) clazz.newInstance();
	}
	
}
