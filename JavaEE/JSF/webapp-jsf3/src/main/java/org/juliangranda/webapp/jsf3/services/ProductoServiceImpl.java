package org.juliangranda.webapp.jsf3.services;

import jakarta.inject.Inject;
import org.juliangranda.webapp.jsf3.controllers.entities.Producto;
import org.juliangranda.webapp.jsf3.repositories.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class ProductoServiceImpl implements ProductoService{

    @Inject
    private CrudRepository<Producto> repository;

    @Override
    public List<Producto> listar() {
        return repository.listar();
    }

    @Override
    public Optional<Producto> porId(Long id) {
        try{
            return Optional.ofNullable(repository.porId(id));
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
