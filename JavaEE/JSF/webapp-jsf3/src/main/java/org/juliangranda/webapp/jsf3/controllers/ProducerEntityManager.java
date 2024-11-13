package org.juliangranda.webapp.jsf3.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContexts;

@RequestScoped
public class ProducerEntityManager {

    @PersistenceContext(name = "ejemploJpa")
    private EntityManager em;

    @Produces
    @RequestScoped
    private EntityManager beanEntityManager() {
        return em;
    }
}