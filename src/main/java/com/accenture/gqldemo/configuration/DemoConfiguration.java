package com.accenture.gqldemo.configuration;

import com.accenture.gqldemo.data.dao.ChickenDAO;
import com.accenture.gqldemo.resolver.ChickenQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfiguration {

    @Autowired
    ChickenDAO chickenDAO;

    //testear si con simple DI de spring por autowired no hace falta tanto boilerplate
    @Bean
    public ChickenQuery query() {
        return new ChickenQuery(chickenDAO);
    }
}
