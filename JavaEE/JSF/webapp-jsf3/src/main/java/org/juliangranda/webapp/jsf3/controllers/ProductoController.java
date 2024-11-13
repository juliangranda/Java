package org.juliangranda.webapp.jsf3.controllers;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.juliangranda.webapp.jsf3.controllers.entities.Producto;
import org.juliangranda.webapp.jsf3.services.ProductoService;

import java.util.Arrays;
import java.util.List;

//@Named
//@RequestScoped
@Model //anotacion tipica para controllers
public class ProductoController {

    @Inject
    private ProductoService service;

    @Produces
    @Model
    public String titulo() {
        return "Hola mundo JavaServer Face 3.0";
    }

    @Produces
    @RequestScoped
    @Named("listado")
    public List<Producto> findAll() {
        return service.listar();
    }
}
