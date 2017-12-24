package com.pedantic.config;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CDIConfig {

    @Produces
    @Dependent
    @PersistenceContext
    public EntityManager entityManager;
}
