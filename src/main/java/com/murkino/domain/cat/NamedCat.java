package com.murkino.domain.cat;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.murkino.domain.cat.color.Color;
import com.murkino.domain.cat.sex.Sex;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor(force = true)
public final class NamedCat implements Cat {

	@Transient
	private final Cat origin;

	private String name;

	private String urlName;

	public NamedCat(Cat origin, String name, String urlName) {
		super();
		this.origin = origin;
		this.name = name;
		this.urlName = urlName;
	}

	public void graduate() {
		origin.graduate();
	}

	public void makeProduction() {
		origin.makeProduction();
	}

	public void sell() {
		origin.sell();
	}

	public void resetColor(Color color) {
		origin.resetColor(color);
	}

	public void resetSex(Sex sex) {
		origin.resetSex(sex);
	}

	public String toJson() throws JsonProcessingException {
		return origin.toJson();
	}

	public void publish() {
		origin.publish();
	}

	public void hide() {
		origin.hide();
	}

	public String id() {
		return origin.id();
	}
	
}
