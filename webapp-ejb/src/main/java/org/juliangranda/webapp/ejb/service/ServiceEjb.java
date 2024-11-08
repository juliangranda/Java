package org.juliangranda.webapp.ejb.service;

import jakarta.ejb.Stateless;

//@RequestScoped
//@Stateful
@Stateless
public class ServiceEjb implements ServiceEjbLocal {

    private int contador;

    public String saludar(String nombre) {
        System.out.println("imprimiendo dentro del ejb con instancia: " + this);
        contador++;
        System.out.println("el valor del contador en metodo saludar " + contador);
        return "Hola que tal " + nombre;
    }
}
