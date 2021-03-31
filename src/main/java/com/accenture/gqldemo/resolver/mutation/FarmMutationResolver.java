package com.accenture.gqldemo.resolver.mutation;

import com.accenture.gqldemo.dao.FarmDAO;
import com.accenture.gqldemo.model.Farm;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FarmMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private FarmDAO repository;

    public Farm addFarm(String name) {
        log.info("creating new farm named '{}'", name);
        Farm newFarm = Farm.builder()
                .name(name)
                .build();
        repository.save(newFarm);
        return newFarm;
    }
}
