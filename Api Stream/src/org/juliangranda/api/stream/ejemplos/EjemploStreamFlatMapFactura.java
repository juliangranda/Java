package org.juliangranda.api.stream.ejemplos;

import org.juliangranda.api.stream.ejemplos.models.Factura;
import org.juliangranda.api.stream.ejemplos.models.Usuario;

import java.util.Arrays;
import java.util.List;

public class EjemploStreamFlatMapFactura {
    public static void main(String[] args) {

        Usuario u1 = new Usuario("Jhon","Doe");
        Usuario u2 = new Usuario("Pepe","Perez");

        u1.addFactura(new Factura("Compras tecnologicas"));
        u1.addFactura(new Factura("Compras muebles"));
        u2.addFactura(new Factura("Bicicleta"));
        u2.addFactura(new Factura("note book gamer"));

        List<Usuario> usuarios = Arrays.asList(u1,u2);
        usuarios.stream()
                .flatMap(u -> u.getFacturas().stream())
                .forEach(f -> System.out.println(f.getDescripcion().concat(" : Cliente ")
                        .concat(f.getUsuario().toString())));


        /*for(Usuario u: usuarios){
            for (Factura f: u.getFacturas()){
                System.out.println(f.getDescripcion());
            }
        }*/
    }
}
