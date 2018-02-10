package com.murkino.domain.cat;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.murkino.domain.cat.color.Color;
import com.murkino.domain.cat.sex.Sex;

@Entity
@Access(AccessType.FIELD)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public interface Cat {

	void graduate();

	void makeProduction();

	void sell();
	
	void resetColor(Color color);
	
	void resetSex(Sex sex);

	String toJson() throws JsonProcessingException;

	void publish();
	
	void hide();

}