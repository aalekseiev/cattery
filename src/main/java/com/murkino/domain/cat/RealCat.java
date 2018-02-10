package com.murkino.domain.cat;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.murkino.domain.cat.color.Color;
import com.murkino.domain.cat.sex.Sex;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor(force = true)
public class RealCat implements Cat {
	
	private final String id;
	
	private CatInbornAttributes inbornAttributes;

	public RealCat(String id, CatInbornAttributes inbornAttributes) {
		super();
		this.id = id;
		this.inbornAttributes = inbornAttributes;
	}
	
	/* (non-Javadoc)
	 * @see com.murkino.domain.cat.Cat#graduate()
	 */
	
	public void resetColor(Color color) {
		inbornAttributes = new CatInbornAttributes(inbornAttributes.sex(), color, inbornAttributes.breed(), inbornAttributes.birthDate());
	}
	
	public void resetSex(Sex sex) {
		inbornAttributes = new CatInbornAttributes(sex, inbornAttributes.color(), inbornAttributes.breed(), inbornAttributes.birthDate());
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
        
        mapper.enableDefaultTyping();
        
        mapper.registerModule(new JavaTimeModule());
//        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
        
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

	@Override
	public Map<String, Object> toMedia() {
		Map<String, Object> retMap = new HashMap<>();
		retMap.put("id", id);
		retMap.put("inbornAttributes", inbornAttributes);
		return retMap ;
	}

}
