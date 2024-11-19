package org.juliangranda.webapp.jsf3.repositories;

import org.juliangranda.webapp.jsf3.entities.Producto;

import java.util.List;

public interface ProductoRepository extends CrudRepository<Producto>{
    List<Producto> buscarPorNombre(String nombre);
}
