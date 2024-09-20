package org.juliangranda.anotaciones.ejemplo.models;

import org.juliangranda.anotaciones.ejemplo.JsonAtributo;

import java.time.LocalDate;

public class Producto {
    //atributos configurados en la anotacion
    //al añadir un valor del atributo en una anotacion es por defecto
    //en caso de que este vacio el atributo.
    @JsonAtributo(capitalizar = true)
    private String nombre;
    @JsonAtributo(nombre = "costo")
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
