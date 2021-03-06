package com.murkino.domain.cat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.murkino.domain.cat.color.Color;
import com.murkino.domain.cat.sex.Sex;

public class NullCat implements Cat {

	@Override
	public void graduate() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void makeProduction() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void sell() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void resetColor(Color color) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String toJson() throws JsonProcessingException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void publish() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void resetSex(Sex sex) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void hide() {
		throw new UnsupportedOperationException();
	}

	public String id() {
		throw new UnsupportedOperationException();
	}
}
