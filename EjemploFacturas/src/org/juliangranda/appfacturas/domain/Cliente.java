package org.juliangranda.appfacturas.domain;

public class Cliente {
    private String nombre;
    private String nif;//# identificacion tributario

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }
}
