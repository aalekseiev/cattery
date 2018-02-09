package com.murkino.domain.cat;

import com.fasterxml.jackson.core.JsonProcessingException;

public class NullCat implements Cat {

	@Override
	public Cat graduate() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Cat makeProduction() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Cat sell() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Cat resetColor(String color) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String toJson() throws JsonProcessingException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Cat publish() {
		throw new UnsupportedOperationException();
	}

}
