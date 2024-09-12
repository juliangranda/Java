package org.juliangranda.api.stream.ejemplos;

import org.juliangranda.api.stream.ejemplos.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStreamFilter {
    public static void main(String[] args) {

        Stream<Usuario> nombres = Stream
                .of("Pato Guzman","Paco Gonzalez","Pepa Gutierrez ","Pepe Mena","Pepe Garcia")
                //posicion 0 el nombre, posicion 1 el apellido.
                .map(nombre -> new Usuario(nombre.split(" ")[0],nombre.split(" ")[1]))
                //flatMap: devuelve o retorna varias salidas por cada elemento,devuelve un stream separado.
                .flatMap( u -> {
                    if(u.getNombre().equalsIgnoreCase("Pepe")){
                        return Stream.of(u);
                    }
                    return Stream.empty();
                })
                .peek(System.out::println)
                ;

        //nombres.forEach(System.out::println);
        System.out.println(nombres.count());


    }
}
