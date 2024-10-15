package org.juliangranda.apiservlet.webapp.headers.services;

import org.juliangranda.apiservlet.webapp.headers.models.Producto;

import java.util.List;

public interface ProductoService {
    List<Producto> listar();
}
