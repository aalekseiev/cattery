package com.murkino.domain;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.murkino.domain.cat.RealCat;
import com.murkino.domain.cat.StatedCat;
import com.murkino.domain.cat.VisibleCat;
import com.murkino.domain.cat.Cat;
import com.murkino.domain.cat.InbornAttributes;
import com.murkino.domain.cat.breed.ScottishStraigh;
import com.murkino.domain.cat.sex.Male;

public class CatTest {

	@Test
	public void testSerializeCat() throws JsonProcessingException {
		Cat cat = new VisibleCat(
					  new StatedCat(
				          new RealCat(
				                  UUID.randomUUID().toString(),
				                  new InbornAttributes(
				                		  new Male(),
				                		  "ny 11",
				                		  new ScottishStraigh(),
				                		  LocalDate.now()
				                  )
				          )
				       ),
				       false);
		cat = cat.makeProduction();
		cat = cat.publish();
		cat = cat.resetColor("ny 25");
		System.out.println(cat.toJson());
		
		System.out.println(cat.toString());
	}

}
