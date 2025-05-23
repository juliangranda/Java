package org.juliangranda.apiservlet.webapp.headers.services;

import org.juliangranda.apiservlet.webapp.headers.models.Categoria;
import org.juliangranda.apiservlet.webapp.headers.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listar();
    Optional<Producto> buscarProducto(String nombre);
    Optional<Producto> porId(Long id);

    void guardar(Producto producto);
    void eliminar(Long id);

    List<Categoria> listarCategoria();

    Optional<Categoria> porIdCategoria(Long id);
}
