package com.yet.spring.core.spring;

import com.yet.spring.core.beans.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.util.Assert;

@Configuration
@PropertySource("classpath:client.properties")
public class AppConfig {

    // было так. И без конструктора
    /*@Autowired
    private Environment environment;*/

    private final Environment environment;
    // Environment сразу создан в Спринг. Он его просто внедряет благодаря autowired.﻿
    @Autowired
    public AppConfig(Environment environment) {
        Assert.notNull(environment, "Environment must not be null");
        this.environment = environment;
    }

    // эти методы убираем, т.к. в Event.java задаем из с пом. SpEL
    /*@Bean
    public Date newDate() {
        return new Date();
    }*/

    /*@Bean
    public DateFormat dateFormat() {
        return DateFormat.getDateTimeInstance();
    }*/

    @Bean
    public Client client() {
        Client client = new Client();
        client.setId(environment.getRequiredProperty("id"));
        client.setFullName(environment.getRequiredProperty("name"));
        client.setGreeting(environment.getProperty("greeting"));
        return client;
    }
}
