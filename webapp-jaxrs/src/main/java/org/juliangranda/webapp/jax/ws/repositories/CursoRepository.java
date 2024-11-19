package org.juliangranda.webapp.jax.ws.repositories;

import org.juliangranda.webapp.jax.ws.models.Curso;

import java.util.List;

public interface CursoRepository {
    List<Curso> listar();
    Curso guardar(Curso curso);
    Curso porId(Long id);
    void eliminar(Long id);
}
