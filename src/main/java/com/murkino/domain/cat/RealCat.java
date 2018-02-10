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
public class RealCat implements Cat {
	
	private final String id;
	
	private InbornAttributes inbornAttributes;

	public RealCat(String id, InbornAttributes inbornAttributes) {
		super();
		this.id = id;
		this.inbornAttributes = inbornAttributes;
	}
	
	/* (non-Javadoc)
	 * @see com.murkino.domain.cat.Cat#graduate()
	 */
	
	public void resetColor(String color) {
		inbornAttributes = new InbornAttributes(inbornAttributes.sex(), color, inbornAttributes.breed(), inbornAttributes.birthDate());
	}
	
	public void resetSex(Sex sex) {
		inbornAttributes = new InbornAttributes(sex, inbornAttributes.color(), inbornAttributes.breed(), inbornAttributes.birthDate());
	}

	/* (non-Javadoc)
	 * @see com.murkino.domain.cat.Cat#toJson()
	 */
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
		//return new StringBuilder("{").append("\"id\"").append(":").append("\"").append(id).append("\"").append("}").toString();
	}

	@Override
	public void graduate() {
//		return new NullCat();
	}

	@Override
	public void makeProduction() {
//		return new NullCat();
	}

	@Override
	public void sell() {
//		return new NullCat();
	}

	@Override
	public void publish() {
//		return new NullCat();
	}

}
