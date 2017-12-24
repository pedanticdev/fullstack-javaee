package com.pedantic.services;

import com.pedantic.entities.Employee;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersistenceService {


    @Inject
    EntityManager entityManager;

    @Inject
    Employee employee;

    @PostConstruct
    private void init() {

    }
}
