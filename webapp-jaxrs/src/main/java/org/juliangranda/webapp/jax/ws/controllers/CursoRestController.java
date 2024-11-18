package org.juliangranda.webapp.jax.ws.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.juliangranda.webapp.jax.ws.models.Curso;
import org.juliangranda.webapp.jax.ws.services.CursoService;

import java.util.List;
import java.util.Optional;

@RequestScoped
@Path("/cursos")
@Produces(MediaType.APPLICATION_XML) //convertir a un contenido XML
public class CursoRestController {

    @Inject
    private CursoService service;

    @GET
    public List<Curso> listar(){
        return service.listar();
    }

    @GET
    @Path("/{id}")//expresion regular / url
    public Response porId(@PathParam("id") Long id){
        Optional<Curso> cursoOptional = service.porId(id);
        if(cursoOptional.isPresent()){
            return Response.ok(cursoOptional.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
