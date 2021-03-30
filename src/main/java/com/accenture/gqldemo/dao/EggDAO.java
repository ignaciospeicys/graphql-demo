package com.accenture.gqldemo.dao;

import com.accenture.gqldemo.model.Egg;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EggDAO extends PagingAndSortingRepository<Egg, Integer> {

}
