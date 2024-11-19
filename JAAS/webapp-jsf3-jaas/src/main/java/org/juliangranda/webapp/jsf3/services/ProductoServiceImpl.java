package org.juliangranda.webapp.jsf3.services;

import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.juliangranda.webapp.jsf3.entities.Categoria;
import org.juliangranda.webapp.jsf3.entities.Producto;
import org.juliangranda.webapp.jsf3.repositories.CrudRepository;
import org.juliangranda.webapp.jsf3.repositories.ProductoRepository;

import java.util.List;
import java.util.Optional;

@Stateless
@DeclareRoles({"USER","ADMIN"}) //roles para el service o EJB
public class ProductoServiceImpl implements ProductoService {

    @Inject
    private ProductoRepository repository;

    @Inject
    private CrudRepository<Categoria> categoriaRepository;

    @Override
    @PermitAll //permitido para todo el publico
    public List<Producto> listar() {
        return repository.listar();
    }

    @Override
    @RolesAllowed({"USER","ADMIN"}) //roles que pueden usar este metodo
    public Optional<Producto> porId(Long id) {
        return Optional.ofNullable(repository.porId(id));
    }

    @Override
    @RolesAllowed({"ADMIN"})
    public void guardar(Producto producto) {
        repository.guardar(producto);
    }

    @Override
    @RolesAllowed({"ADMIN"})
    public void eliminar(Long id) {
        repository.eliminar(id);
    }

    @RolesAllowed({"USER","ADMIN"})
    @Override
    public List<Categoria> listarCategorias() {
        return categoriaRepository.listar();
    }

    @RolesAllowed({"USER","ADMIN"})
    @Override
    public Optional<Categoria> porIdCategoria(Long id) {
        return Optional.ofNullable(categoriaRepository.porId(id));
    }

    @RolesAllowed({"USER","ADMIN"})
    @Override
    public List<Producto> buscarPorNombre(String nombre) {
        return repository.buscarPorNombre(nombre);
    }

}
