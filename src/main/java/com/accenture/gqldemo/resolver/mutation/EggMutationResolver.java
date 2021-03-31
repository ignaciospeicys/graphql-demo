package com.accenture.gqldemo.resolver.mutation;

import com.accenture.gqldemo.dao.EggDAO;
import com.accenture.gqldemo.enums.EggColorEnum;
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

    public Egg addEgg(String color, Integer chickenId) {
        log.info("creating new egg belonging to chicken id: {}", chickenId);
        Egg newEgg = Egg.builder()
                .color(EggColorEnum.valueOf(color))
                .chickenId(chickenId)
                .build();
        repository.save(newEgg);
        return newEgg;
    }
}
