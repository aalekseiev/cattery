package com.murkino.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.murkino.domain.cat.HibernateCat;

@Repository
public interface CatSpringDataRepository extends CrudRepository<HibernateCat, String> {

}
