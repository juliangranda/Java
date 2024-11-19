package org.juliangranda.cliente.jaxrs;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.juliangranda.cliente.jaxrs.models.Curso;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();
        WebTarget rootUri = client.target("http://localhost:8080/webapp-jaxrs/api").path("/cursos");

        System.out.println("========== porId =========");
        //alternativa
//        Curso curso = rootUri.path("/2")
//                .request(MediaType.APPLICATION_JSON)
//                .get(Curso.class);
//        System.out.println(curso);

        Response response = rootUri.path("/2")
                .request(MediaType.APPLICATION_JSON).get();
        Curso curso = response.readEntity(Curso.class);
        System.out.println(curso);
        System.out.println(response.getStatus());
        System.out.println(response.getMediaType());

        System.out.println("========== listar =========");
//        List<Curso> cursos = rootUri.request(MediaType.APPLICATION_JSON)
//                .get(Response.class)
//                .readEntity(new GenericType<List<Curso>>(){});
//        cursos.forEach(System.out::println);
        
        response = rootUri.request(MediaType.APPLICATION_JSON)
                .get();
        List<Curso> cursos = response.readEntity(new GenericType<List<Curso>>(){});
        cursos.forEach(System.out::println);



    }
}
