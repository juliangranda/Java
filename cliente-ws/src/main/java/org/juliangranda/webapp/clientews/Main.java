package org.juliangranda.webapp.clientews;

import org.juliangranda.webapp.jaxws.services.Curso;
import org.juliangranda.webapp.jaxws.services.ServicioWs;
import org.juliangranda.webapp.jaxws.services.ServicioWsImplService;

public class Main {
    public static void main(String[] args) {
        ServicioWs service = new ServicioWsImplService().getServicioWsImplPort();
        System.out.println("el saludo: " + service.saludar("Julian"));

        Curso curso = new Curso();
        curso.setNombre("angular");
        Curso respuesta = service.crear(curso);
        System.out.println("nuevo curso: " + curso.getNombre());
        service.listar().forEach(c -> System.out.println(c.getNombre()));
    }
}