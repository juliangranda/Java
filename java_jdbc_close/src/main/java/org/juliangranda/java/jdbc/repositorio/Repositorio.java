package org.juliangranda.java.jdbc.repositorio;

import java.util.List;

//tema de consulta y operaciones de la base de datos.
//CRUD - DAO/Repositorio.
public interface Repositorio<T> {
    List<T> listar();

    T porId(Long id);

    void guardar(T t);

    void eliminar(Long id);

}
