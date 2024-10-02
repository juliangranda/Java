package org.juliangranda.java.appmockito.ejemplos.repositories;

import org.juliangranda.java.appmockito.ejemplos.models.Examen;

import java.util.List;

public interface ExamenRepository {
    List<Examen> findAll();
}
