package com.accenture.gqldemo.resolver.query;

import com.accenture.gqldemo.dao.FarmDAO;
import com.accenture.gqldemo.model.Farm;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FarmQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private FarmDAO repository;

    public Farm farmById(Integer id) {
        log.info("fetching farm by id: {}", id);
        return repository.findById(id).orElse(null);
    }
}
