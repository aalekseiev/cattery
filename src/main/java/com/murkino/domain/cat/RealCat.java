package com.murkino.domain.cat;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.murkino.domain.cat.breed.Breed;
import com.murkino.domain.cat.color.Color;
import com.murkino.domain.cat.sex.Sex;
import com.murkino.mapper.MurkinoObjectMapper;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor(force = true)
public class RealCat implements Cat {
	
	private Sex sex;

	private Color color;

	private final Breed breed;
	
	private final LocalDate birthDate;
	
	/* (non-Javadoc)
	 * @see com.murkino.domain.cat.Cat#graduate()
	 */
	
	public void resetColor(Color color) {
		this.color = color;
	}
	
	public void resetSex(Sex sex) {
		this.sex = sex;
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
		new NullCat().graduate();
	}

	@Override
	public void makeProduction() {
		new NullCat().makeProduction();
	}

	@Override
	public void sell() {
		new NullCat().sell();
	}

	@Override
	public void publish() {
		new NullCat().publish();
	}

	@Override
	public void hide() {
		new NullCat().hide();
	}

	public RealCat(Sex sex, Color color, Breed breed, LocalDate birthDate) {
		this.sex = sex;
		this.color = color;
		this.breed = breed;
		this.birthDate = birthDate;
	}

	@Override
	public String id() {
		return new NullCat().id();
	}
}
