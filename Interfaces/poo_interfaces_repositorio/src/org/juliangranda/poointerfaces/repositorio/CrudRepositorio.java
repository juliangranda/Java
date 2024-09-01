package org.juliangranda.poointerfaces.repositorio;

import org.juliangranda.poointerfaces.modelo.Cliente;
import org.juliangranda.poointerfaces.repositorio.excepciones.AccesoDatoException;
import org.juliangranda.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;

import java.util.List;

public interface CrudRepositorio<T> {
    List<T> listar();
    T porId(Integer id) throws AccesoDatoException;
    void crear(T t) throws AccesoDatoException;
    void editar(T t) throws AccesoDatoException;
    void eliminar(Integer id) throws AccesoDatoException;

}
