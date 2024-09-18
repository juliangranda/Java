package org.juliangranda.optional.ejemplo.repositorio;

import org.juliangranda.optional.ejemplo.models.Computador;

import java.util.Optional;

public interface Repositorio<T> {

    Optional<Computador> filtrar(String nombre);

}
