package com.accenture.gqldemo.resolver.query;

import com.accenture.gqldemo.dao.ChickenDAO;
import com.accenture.gqldemo.enums.BreedEnum;
import com.accenture.gqldemo.exception.ElementNotFoundException;
import com.accenture.gqldemo.model.Chicken;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.DataFetchingFieldSelectionSet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * provides a high level mechanism for routing queries
 * REST equivalent of a controller
 * method names should match with the defined queries in the *.graphqls file
 * see also {@link graphql.schema.DataFetcher} for a lower level implementation
 */
@Slf4j
@Component
public class ChickenQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private ChickenDAO repository;

    public List<Chicken> chickens() {
        log.info("fetching all chickens");
        return repository.findAll();
    }

    @Transactional
    public Chicken chickenById(Integer id, DataFetchingEnvironment env) throws ElementNotFoundException {
        log.info("fetching chicken by id: {}", id);
        DataFetchingFieldSelectionSet selectionSet = env.getSelectionSet();
        Map<String, Map<String, Object>> arguments = selectionSet.getArguments();
        Chicken chicken = repository.findById(id).orElseThrow(ElementNotFoundException::new);
        if (selectionSet.contains("farm")) chicken.getFarm(); //TODO: standarize through enum or depenency method
        return chicken;
    }

    public Chicken chickenByName(String name) {
        log.info("fetching chicken by name: {}", name);
        return repository.findByName(name);
    }

    public List<Chicken> chickensByBreed(String breed) {
        BreedEnum breedEnum = BreedEnum.findByName(breed);
        log.info("fetching chickens by breed: {}", breedEnum.name());
        return repository.findAllByBreed(breedEnum);
    }

}
