package org.juliangranda.java.jdbc.tarea37.mantenedorusuarios.repositorio;

import org.juliangranda.java.jdbc.tarea37.mantenedorusuarios.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public interface IRepositorio<T> {

    List<T> listar();

    T porId(Long id);

    void guardar(T t);

    void eliminar(Long id);

}
