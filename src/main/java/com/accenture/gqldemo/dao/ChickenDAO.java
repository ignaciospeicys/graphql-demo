package com.accenture.gqldemo.dao;

import com.accenture.gqldemo.enums.BreedEnum;
import com.accenture.gqldemo.model.Chicken;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChickenDAO extends PagingAndSortingRepository<Chicken, Integer> {

    List<Chicken> findAll();

    Chicken findByName(String name);

    List<Chicken> findAllByBreed(BreedEnum breed);
}
