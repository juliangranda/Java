package org.juliangranda.webapp.jax.ws.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.juliangranda.webapp.jax.ws.models.Curso;
import org.juliangranda.webapp.jax.ws.repositories.CursoRepository;

import java.util.List;

@Stateless
@WebService(endpointInterface = "org.juliangranda.webapp.jax.ws.services.CursoServicioWs")
public class CursoServicioWsImpl implements CursoServicioWs {

    @Inject
    private CursoRepository repository;

    @Override
    @WebMethod
    public List<Curso> listar() {
        return repository.listar();
    }

    @Override
    @WebMethod
    public Curso guardar(Curso curso) {
        return repository.guardar(curso);
    }
}
