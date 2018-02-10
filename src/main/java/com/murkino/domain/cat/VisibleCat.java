package com.murkino.domain.cat;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.murkino.domain.cat.sex.Sex;

import lombok.ToString;

@ToString
public class VisibleCat implements Cat {

	private final Cat origin;
	
	private Boolean visible;

	public VisibleCat(Cat origin, Boolean visible) {
		this.origin = origin;
		this.visible = visible;
	}

	@Override
	public void graduate() {
		origin.graduate();
	}

	@Override
	public void makeProduction() {
		origin.makeProduction();
	}

	@Override
	public void sell() {
		origin.sell();
	}

	
	public void hide() {
		visible = false;
	}
	
	@Override
	public void publish() {
		this.visible = true;
	}

	
	@Override
	public void resetColor(String color) {
		origin.resetColor(color);
	}

	public Boolean visible() {
		return this.visible;
	}
	
	@Override
	public String toJson() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		// Avoid having to annotate the Person class
        // Requires Java 8, pass -parameters to javac
        // and jackson-module-parameter-names as a dependency
        mapper.registerModule(new ParameterNamesModule());
 
        // make private fields of Person visible to Jackson
        mapper.setVisibility(FIELD, ANY);

        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        
        return mapper.writeValueAsString(this);
	}

	@Override
	public void resetSex(Sex sex) {
		origin.resetSex(sex);
	}

}
