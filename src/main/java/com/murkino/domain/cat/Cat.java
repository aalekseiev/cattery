package com.murkino.domain.cat;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.murkino.domain.cat.state.GraduatedState;
import com.murkino.domain.cat.state.NewState;
import com.murkino.domain.cat.state.ProductionState;
import com.murkino.domain.cat.state.SoldState;
import com.murkino.domain.cat.state.State;

import lombok.ToString;

@ToString
public final class Cat {
	
	private final String id;
	
	private final InbornAttributes inbornAttributes;
	
	private final State state;
	
	private final Boolean visible;

	private Cat(String id, InbornAttributes inbornAttributes, State state, Boolean visible) {
		super();
		this.id = id;
		this.inbornAttributes = inbornAttributes;
		this.state = state;
		this.visible = visible;
	}
	
	public Cat(String id, InbornAttributes inbornAttributes) {
		this(id, inbornAttributes, new NewState(), false);
	}
	
	public Cat graduate() {
		return new Cat(id, inbornAttributes, new GraduatedState(), visible);
	}
	
	public Cat makeProduction() {
		return new Cat(id, inbornAttributes, new ProductionState(), visible);
	}
	
	public Cat sell() {
		return new Cat(id, inbornAttributes, new SoldState(), visible);
	}
	
	public Cat hide() {
		return new Cat(id, inbornAttributes, state, false);
	}
	
	public Cat publish() {
		return new Cat(id, inbornAttributes, state, true);
	}

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
		//return new StringBuilder("{").append("\"id\"").append(":").append("\"").append(id).append("\"").append("}").toString();
	}

	public Cat resetColor(String color) {
		InbornAttributes newInbornAttributes = new InbornAttributes(inbornAttributes.sex(), color, inbornAttributes.breed(), inbornAttributes.birthDate());
		
		return new Cat(id, newInbornAttributes, state, visible);
	}
}
