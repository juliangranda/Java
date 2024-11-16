package org.juliangranda.webapp.jaxws.services;

import jakarta.jws.WebService;
import org.juliangranda.webapp.jaxws.models.Curso;

import java.util.List;

//webservice=todos los metodos de esta interfaz se van a publicar en este servicio
@WebService
public interface ServicioWs {
    String saludar(String persona);
    List<Curso> listar();
    Curso crear(Curso curso);
}
