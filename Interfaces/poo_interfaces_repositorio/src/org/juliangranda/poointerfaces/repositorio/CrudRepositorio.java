package org.juliangranda.poointerfaces.repositorio;

import org.juliangranda.poointerfaces.modelo.Cliente;

import java.util.List;

public interface CrudRepositorio<T> {
    List<T> listar();
    Cliente porID(Integer id);
    void crear(T cliente);
    void editar(T cliente);
    void eliminar(Integer id);

}
