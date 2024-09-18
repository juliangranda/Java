package org.juliangranda.optional.ejemplo.models;

import java.util.Optional;

public class Fabricante {
    private String nombre;

    public Fabricante(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
