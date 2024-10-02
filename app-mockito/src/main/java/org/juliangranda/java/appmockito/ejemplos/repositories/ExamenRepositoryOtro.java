package org.juliangranda.java.appmockito.ejemplos.repositories;

import org.juliangranda.java.appmockito.ejemplos.models.Examen;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExamenRepositoryOtro implements ExamenRepository{
    @Override
    public Examen guardar(Examen examen) {
        return null;
    }

    @Override
    public List<Examen> findAll() {
        try {
            System.out.println("ExamenRepositoryOtro");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return List.of();
    }
}
