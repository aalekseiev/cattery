package com.murkino.mapper;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

public class MurkinoObjectMapper extends ObjectMapper {

	private static final long serialVersionUID = 1L;

	public MurkinoObjectMapper() {
		super();
	}

	@Override
	public <T> T readValue(String content, Class<T> valueType)
			throws IOException, JsonParseException, JsonMappingException {
		setupMapper();
		return super.readValue(content, valueType);
	}

	@Override
	public String writeValueAsString(Object value) throws JsonProcessingException {
		setupMapper();
		return super.writeValueAsString(value);
	}

	private void setupMapper() {
		// Avoid having to annotate the Cat class
        // Requires Java 8, pass -parameters to javac
        // and jackson-module-parameter-names as a dependency
        registerModule(new ParameterNamesModule());
 
        // make private fields of Person visible to Jackson
        setVisibility(FIELD, ANY);

        configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        configure(SerializationFeature.INDENT_OUTPUT, true);
        
        enableDefaultTyping();
        
        registerModule(new JavaTimeModule());
	}

	
	
}
