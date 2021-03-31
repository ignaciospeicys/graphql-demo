package com.accenture.gqldemo.resolver.mutation;

import com.accenture.gqldemo.dao.EggDAO;
import com.accenture.gqldemo.model.Egg;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EggMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private EggDAO repository;

    public Egg addEgg(String name, String color, Integer chickenId) {
        Egg newEgg = Egg.builder()
                .name(name)
                .build();
        repository.save(newEgg);
        return newEgg;
    }
}
