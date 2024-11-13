package org.juliangranda.webapp.jsf3.controllers.entities;

public class Producto {

    public Producto() {
    }

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
