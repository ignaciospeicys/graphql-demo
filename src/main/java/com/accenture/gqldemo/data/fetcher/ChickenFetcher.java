package com.accenture.gqldemo.data.fetcher;

import com.accenture.gqldemo.model.Chicken;
import com.accenture.gqldemo.data.dao.ChickenDAO;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class ChickenFetcher implements DataFetcher<Chicken> {

    @Autowired
    private ChickenDAO chickenDAO;

    @Override
    public Chicken get(DataFetchingEnvironment environment) {
        Optional<Chicken> chicken = chickenDAO.findById(environment.getArgument("id"));
        return chicken.get();
    }
}
