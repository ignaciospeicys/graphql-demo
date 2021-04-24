package com.accenture.gqldemo.resolver.mutation;

import com.accenture.gqldemo.dao.ChickenDAO;
import com.accenture.gqldemo.enums.BreedEnum;
import com.accenture.gqldemo.model.Chicken;
import com.accenture.gqldemo.resolver.query.ChickenQueryResolver;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * see also {@link ChickenQueryResolver}
 */
@Slf4j
@Component
public class ChickenMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private ChickenDAO repository;

    public Chicken addChicken(String name, Integer age, String breed, Integer farmId) {
        log.info("creating new chicken of breed: {} belonging to farm id: {}", breed, farmId);
        Chicken newChicken = Chicken.builder()
                .name(name)
                .age(age)
                .breed(BreedEnum.findByName(breed))
                .farmId(farmId)
                .build();
        repository.save(newChicken);
        return newChicken;
    }

    public Boolean deleteChickenById(Integer id) {
        log.info("deleting chicken by id: {}", id);
        Boolean success = false;
        try {
            repository.deleteById(id);
            success = true;
        } catch (Exception ex) {
            log.error("exception thrown while deleting chicken by id, message: {}", ex.getMessage());
        }
        return success;
    }
}
