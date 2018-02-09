package com.murkino.domain.cat;

import java.time.LocalDate;

import com.murkino.domain.cat.breed.Breed;
import com.murkino.domain.cat.sex.Sex;

import lombok.ToString;

@ToString
public final class InbornAttributes {

	private final Sex sex;

	private final String color;

	private final Breed breed;
	
	private final LocalDate birthDate;

	public InbornAttributes(Sex sex, String color, Breed breed, LocalDate birthDate) {
		super();
		this.sex = sex;
		this.color = color;
		this.breed = breed;
		this.birthDate = birthDate;
	}

	public Sex sex() {
		return this.sex;
	}
	
	public Breed breed() {
		return this.breed;
	}
	
	public LocalDate birthDate() {
		return this.birthDate;
	}
}
