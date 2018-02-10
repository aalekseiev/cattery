package com.murkino.repository;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.murkino.application.MurkinoApplication;
import com.murkino.domain.cat.Cat;
import com.murkino.domain.cat.DescribedCat;
import com.murkino.domain.cat.HibernateCat;
import com.murkino.domain.cat.IdentifiedCat;
import com.murkino.domain.cat.NamedCat;
import com.murkino.domain.cat.RealCat;
import com.murkino.domain.cat.StatedCat;
import com.murkino.domain.cat.VisibleCat;
import com.murkino.domain.cat.breed.ScottishStraight;
import com.murkino.domain.cat.color.CatColor;
import com.murkino.domain.cat.sex.Male;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MurkinoApplication.class)
public class CatSpringDataRepositoryTest {

	@Autowired
	private CatSpringDataRepository repo;
	
	@Test
	public void test() throws JsonProcessingException {
		
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
		
		HibernateCat ket = new HibernateCat(cat.id(), cat.toJson());
		repo.save(ket);
		
		Iterable<HibernateCat> findAll = repo.findAll();
		for (HibernateCat hibernateCat : findAll) {
			System.out.println(hibernateCat);
		}
		
	}
	
}
