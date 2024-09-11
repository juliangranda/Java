package org.juliangranda.api.stream.ejemplos;

import org.juliangranda.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamFilterEmpty {
    public static void main(String[] args) {

        long count = Stream
                .of("Pato Guzman","Paco Gonzalez","","Pepe Mena","")
                //si alguno de los nombre es vacio.
                .filter(String::isEmpty)
                .peek(System.out::println)
                .count()
                ;

        System.out.println("count = " + count);


    }
}
