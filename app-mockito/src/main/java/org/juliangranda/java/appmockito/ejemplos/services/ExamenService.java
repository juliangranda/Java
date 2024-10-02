package org.juliangranda.java.appmockito.ejemplos.services;

import org.juliangranda.java.appmockito.ejemplos.models.Examen;

public interface ExamenService {

    Examen findExamenPorNombre(String nombre);
}
