package org.juliangranda.anotaciones.ejemplo;

import org.juliangranda.anotaciones.ejemplo.models.Producto;

import java.time.LocalDate;

public class EjemploAnotacion {
    public static void main(String[] args) {

        Producto p = new Producto();
        p.setFecha(LocalDate.now());
        p.setNombre("mesa centro roble");
        p.setPrecio(1000L);
    }
}
