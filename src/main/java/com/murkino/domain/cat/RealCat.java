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
public class RealCat implements Cat {
	
	private final String id;
	
	private final InbornAttributes inbornAttributes;
	
	private final State state;

	private RealCat(String id, InbornAttributes inbornAttributes, State state) {
		super();
		this.id = id;
		this.inbornAttributes = inbornAttributes;
		this.state = state;
	}
	
	public RealCat(String id, InbornAttributes inbornAttributes) {
		this(id, inbornAttributes, new NewState());
	}
	
	/* (non-Javadoc)
	 * @see com.murkino.domain.cat.Cat#graduate()
	 */
	@Override
	public Cat graduate() {
		return new RealCat(id, inbornAttributes, new GraduatedState());
	}
	
	/* (non-Javadoc)
	 * @see com.murkino.domain.cat.Cat#makeProduction()
	 */
	@Override
	public RealCat makeProduction() {
		return new RealCat(id, inbornAttributes, new ProductionState());
	}
	
	/* (non-Javadoc)
	 * @see com.murkino.domain.cat.Cat#sell()
	 */
	@Override
	public Cat sell() {
		return new RealCat(id, inbornAttributes, new SoldState());
	}
	
	public RealCat resetColor(String color) {
		InbornAttributes newInbornAttributes = new InbornAttributes(inbornAttributes.sex(), color, inbornAttributes.breed(), inbornAttributes.birthDate());
		
		return new RealCat(id, newInbornAttributes, state);
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

}
