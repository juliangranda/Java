package org.juliangranda.patrones.observer.ejemplo;

import org.juliangranda.patrones.observer.UsuarioRepositorio;

public class EjemploObserver2 {
    public static void main(String[] args) {
        UsuarioRepositorio repo = new UsuarioRepositorio();
        repo.addObserver((o,u) -> System.out.println("Enviando un Email al usuario " + u));
        repo.addObserver((o,u) -> System.out.println("Enviando un Email al administrador"));
        repo.addObserver((o,u) -> System.out.println("Guardando info del usuario "+
                u +" en el logs"));
        repo.crearUsuario("Andres");

    }
}
