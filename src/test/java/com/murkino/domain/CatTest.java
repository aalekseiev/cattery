package com.murkino.domain;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.murkino.domain.cat.RealCat;
import com.murkino.domain.cat.StatedCat;
import com.murkino.domain.cat.VisibleCat;
import com.murkino.domain.cat.Cat;
import com.murkino.domain.cat.CatInbornAttributes;
import com.murkino.domain.cat.breed.ScottishFoldShorthairs;
import com.murkino.domain.cat.breed.ScottishStraigh;
import com.murkino.domain.cat.color.CatColor;
import com.murkino.domain.cat.sex.Male;

public class CatTest {

	@Test
	public void testSerializeDeserializeCat() throws IOException {
		Cat cat = new VisibleCat(
					  new StatedCat(
				          new RealCat(
				                  UUID.randomUUID().toString(),
				                  new CatInbornAttributes(
				                		  new Male(),
				                		  new CatColor("ny 11"),
				                		  new ScottishStraigh(),
				                		  LocalDate.now()
				                  )
				          )
				       ),
				       false);
		cat.makeProduction();
		cat.publish();
		cat.resetColor(new CatColor("ny 25"));
		
		String json = cat.toJson();
		System.out.println(json);
		
		System.out.println("------------------------------");
		
		ObjectMapper mapper = new ObjectMapper();
		// Avoid having to annotate the Person class
        // Requires Java 8, pass -parameters to javac
        // and jackson-module-parameter-names as a dependency
        mapper.registerModule(new ParameterNamesModule());
 
        // make private fields of Cat visible to Jackson
        mapper.setVisibility(FIELD, ANY);

        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        
        mapper.enableDefaultTyping();
        
        mapper.registerModule(new JavaTimeModule());
        
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
