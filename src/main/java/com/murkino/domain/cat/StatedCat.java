package com.murkino.domain.cat;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.DiscriminatorValue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.murkino.domain.cat.color.Color;
import com.murkino.domain.cat.sex.Sex;
import com.murkino.domain.cat.state.GraduatedState;
import com.murkino.domain.cat.state.NewState;
import com.murkino.domain.cat.state.ProductionState;
import com.murkino.domain.cat.state.SoldState;
import com.murkino.domain.cat.state.State;
import com.murkino.mapper.MurkinoObjectMapper;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor(force = true)
@DiscriminatorValue("StatedCat")
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

	public void resetColor(Color color) {
		origin.resetColor(color);
	}

	@Override
	public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new MurkinoObjectMapper();
        
        Map<String, Object> map = new HashMap<>();
        map.put("entity", this);
        return mapper.writeValueAsString(this);
	}

	@Override
	public void resetSex(Sex sex) {
		origin.resetSex(sex);	
	}

	@Override
	public void hide() {
		origin.hide();
	}

}
