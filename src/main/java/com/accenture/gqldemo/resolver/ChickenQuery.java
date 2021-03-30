package com.accenture.gqldemo.resolver;

import com.accenture.gqldemo.data.dao.ChickenDAO;
import com.accenture.gqldemo.model.Chicken;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class ChickenQuery implements GraphQLQueryResolver {

    private ChickenDAO repository;

    public ChickenQuery(ChickenDAO repository) {
        this.repository = repository;
    }

    public List<Chicken> chickens() {
        return repository.findAll();
    }
}
