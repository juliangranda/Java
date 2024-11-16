package org.juliangranda.webapp.jax.ws.services;

import jakarta.jws.WebService;
import org.juliangranda.webapp.jax.ws.models.Curso;

import java.util.List;

//webservice=todos los metodos de esta interfaz se van a publicar en este servicio
@WebService
public interface CursoServicioWs {
    List<Curso> listar();
    Curso guardar(Curso curso);
}
