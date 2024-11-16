package org.juliangranda.webapp.jaxws.services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.juliangranda.webapp.jaxws.models.Curso;

import java.util.Arrays;
import java.util.List;

@WebService(endpointInterface = "org.juliangranda.webapp.jaxws.services.ServicioWs")
public class ServicioWsImpl implements ServicioWs {
    private int contador;

    //@WebMethod = son los metodos del servicio web
    @Override
    @WebMethod
    public String saludar(String persona) {
        System.out.println("imprimir dentro del servicio web con instancia: " + this);
        contador++;
        System.out.println("valor del contador en metodo saludar " + contador);
        return "Hola que tal " + persona;
    }

    @Override
    @WebMethod
    public List<Curso> listar() {
        return Arrays.asList(new Curso("java"),new Curso("spring"),new Curso("jakartaee"));
    }

    @Override
    @WebMethod
    public Curso crear(Curso curso) {
        System.out.println("Curso guardado con exito " + curso.getNombre());
        Curso nuevoCurso = new Curso();
        nuevoCurso.setNombre(curso.getNombre());
        return nuevoCurso;
    }
}
