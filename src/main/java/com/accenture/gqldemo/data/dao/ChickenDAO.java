package com.accenture.gqldemo.data.dao;

import com.accenture.gqldemo.model.Chicken;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChickenDAO extends PagingAndSortingRepository<Chicken, Integer> {

    List<Chicken> findAll();
}
