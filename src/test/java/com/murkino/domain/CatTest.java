package com.murkino.domain;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.UUID;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.murkino.domain.cat.Cat;
import com.murkino.domain.cat.CatInbornAttributes;
import com.murkino.domain.cat.DescribedCat;
import com.murkino.domain.cat.IdentifiedCat;
import com.murkino.domain.cat.NamedCat;
import com.murkino.domain.cat.RealCat;
import com.murkino.domain.cat.StatedCat;
import com.murkino.domain.cat.VisibleCat;
import com.murkino.domain.cat.breed.ScottishFoldShorthairs;
import com.murkino.domain.cat.breed.ScottishStraight;
import com.murkino.domain.cat.color.CatColor;
import com.murkino.domain.cat.sex.Male;
import com.murkino.mapper.MurkinoObjectMapper;

public class CatTest {

	@Test
	public void testSerializeDeserializeCat() throws IOException {
		Cat cat = new VisibleCat(
					  new StatedCat(
						  new DescribedCat(
						      new NamedCat(		  
							      new IdentifiedCat(
							          new RealCat(
				                		  new Male(),
				                		  new CatColor("ny 11"),
				                		  new ScottishStraight(),
				                		  LocalDate.now()
							          ),
							          UUID.randomUUID().toString()
							      ),
							      "Demimur",
							      "deminur"
							  ),
					          "Just plain description"
					      )
				       ),
				       false
				   );
		System.out.println("------------------------------");
		System.out.println(cat);
		
		cat.makeProduction();
		System.out.println("------------------------------");
		System.out.println(cat);
		
		cat.publish();
		System.out.println("------------------------------");
		System.out.println(cat);
		
		cat.resetColor(new CatColor("ny 25"));
		System.out.println("------------------------------");
		System.out.println(cat);
		
		String json = cat.toJson();
		System.out.println(json);
		
		System.out.println("------------------------------");
		
		ObjectMapper mapper = new MurkinoObjectMapper();
        
		Cat kit = (Cat) mapper.readValue(json, HashMap.class).get("entity");
		System.out.println(kit);
	}
	
	@Test
	public void testSerializeInbornAttributes() throws Exception {
		CatInbornAttributes attrs = new CatInbornAttributes(new Male(),
				new CatColor("ny 12"),
				new ScottishFoldShorthairs(), 
				LocalDate.now());
		
		System.out.println(attrs.toJson());
	}

}
