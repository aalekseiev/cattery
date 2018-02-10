package com.murkino.domain.cat;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.murkino.domain.cat.sex.Sex;
import com.murkino.domain.cat.state.GraduatedState;
import com.murkino.domain.cat.state.NewState;
import com.murkino.domain.cat.state.ProductionState;
import com.murkino.domain.cat.state.SoldState;
import com.murkino.domain.cat.state.State;

import lombok.ToString;

@ToString
public class StatedCat implements Cat {

	private final Cat origin;
	
	private State state;

	public StatedCat(Cat origin, State state) {
		super();
		this.origin = origin;
		this.state = state;
	}
	
	public StatedCat(Cat origin) {
		super();
		this.origin = origin;
		this.state = new NewState();
	}

	@Override
	public void graduate() {
		state = new GraduatedState();
	}
	
	/* (non-Javadoc)
	 * @see com.murkino.domain.cat.Cat#makeProduction()
	 */
	@Override
	public void makeProduction() {
		state = new ProductionState();
	}
	
	/* (non-Javadoc)
	 * @see com.murkino.domain.cat.Cat#sell()
	 */
	@Override
	public void sell() {
		state = new SoldState();
	}

	public void publish() {
		origin.publish();
	}

	public void resetColor(String color) {
		origin.resetColor(color);
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
