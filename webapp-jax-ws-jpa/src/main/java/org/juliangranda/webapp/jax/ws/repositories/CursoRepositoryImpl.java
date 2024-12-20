package org.juliangranda.webapp.jax.ws.repositories;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.juliangranda.webapp.jax.ws.models.Curso;

import java.util.List;

@RequestScoped
public class CursoRepositoryImpl implements CursoRepository{
    @Inject
    private EntityManager em;

    @Override
    public List<Curso> listar() {
        return em.createQuery("select c from Curso c", Curso.class).getResultList();
    }

    @Override
    public Curso guardar(Curso curso) {
        em.persist(curso);
        return curso;
    }
}
