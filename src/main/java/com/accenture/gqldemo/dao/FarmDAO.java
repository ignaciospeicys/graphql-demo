package com.accenture.gqldemo.dao;

import com.accenture.gqldemo.model.Farm;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmDAO extends PagingAndSortingRepository<Farm, Integer> {

}
