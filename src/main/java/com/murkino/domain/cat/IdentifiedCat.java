package com.murkino.domain.cat;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Id;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.murkino.domain.cat.color.Color;
import com.murkino.domain.cat.sex.Sex;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor(force = true)
@DiscriminatorValue("IdentifiedCat")
public class IdentifiedCat implements Cat {

	private final Cat origin;

    @Id
	private final String id;

	public IdentifiedCat(Cat origin, String id) {
		super();
		this.origin = origin;
		this.id = id;
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
	
	

}
