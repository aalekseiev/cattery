package com.murkino.domain.cat;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;

import java.time.LocalDate;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.murkino.domain.cat.breed.Breed;
import com.murkino.domain.cat.color.Color;
import com.murkino.domain.cat.sex.Sex;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor(force = true)
@Embeddable
public final class CatInbornAttributes {

	private final Sex sex;

	private final Color color;

	private final Breed breed;
	
	private final LocalDate birthDate;

	public CatInbornAttributes(Sex sex, Color color, Breed breed, LocalDate birthDate) {
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
	
	public Color color() {
		return this.color;
	}

	public String toJson() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		
		// Avoid having to annotate the Person class
        // Requires Java 8, pass -parameters to javac
        // and jackson-module-parameter-names as a dependency
        mapper.registerModule(new ParameterNamesModule());
 
        // make private fields of Person visible to Jackson
        mapper.setVisibility(FIELD, ANY);

        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        
        mapper.enableDefaultTyping();
        
		return mapper.writeValueAsString(this);
	}
}
