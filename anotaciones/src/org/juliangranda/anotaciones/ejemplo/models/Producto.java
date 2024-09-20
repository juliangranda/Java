package org.juliangranda.anotaciones.ejemplo.models;

import org.juliangranda.anotaciones.ejemplo.JsonAtributo;

import java.time.LocalDate;

public class Producto {
    //atributos configurados en la anotacion
    @JsonAtributo
    private String nombre;
    @JsonAtributo
    private Long precio;


    private LocalDate fecha;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
