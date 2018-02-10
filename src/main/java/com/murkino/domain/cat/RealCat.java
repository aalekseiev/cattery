package com.murkino.domain.cat;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.murkino.domain.cat.color.Color;
import com.murkino.domain.cat.sex.Sex;
import com.murkino.mapper.MurkinoObjectMapper;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor(force = true)
@DiscriminatorValue("RealCat")
public class RealCat implements Cat {
	
	private final String id;
	
	@Embedded
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
		ObjectMapper mapper = new MurkinoObjectMapper();
        
        Map<String, Object> map = new HashMap<>();
        map.put("entity", this);
        return mapper.writeValueAsString(this);
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
	public void hide() {
		
	}

}
