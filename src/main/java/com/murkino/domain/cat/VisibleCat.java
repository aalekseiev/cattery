package com.murkino.domain.cat;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

public class VisibleCat implements Cat {

	private final Cat origin;
	
	private final Boolean visible;

	public VisibleCat(Cat origin, Boolean visible) {
		this.origin = origin;
		this.visible = visible;
	}

	@Override
	public Cat graduate() {
		return origin.graduate();
	}

	@Override
	public Cat makeProduction() {
		return origin.makeProduction();
	}

	@Override
	public Cat sell() {
		return origin.sell();
	}

	
	public Cat hide() {
		return new VisibleCat(origin, false);
	}
	
	public Cat publish() {
		return new VisibleCat(origin, true);
	}

	
	@Override
	public Cat resetColor(String color) {
		return origin.resetColor(color);
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

}
