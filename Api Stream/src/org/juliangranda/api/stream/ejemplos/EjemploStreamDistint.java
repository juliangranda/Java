package org.juliangranda.api.stream.ejemplos;

import org.juliangranda.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamDistint {
    public static void main(String[] args) {

        Stream<String> nombres = Stream.of("Pato Guzman","Paco Gonzalez","Pepa Gutierrez ","Pepe Mena",
                        "Pepe Garcia","Paco Gonzalez","Paco Gonzalez","Paco Gonzalez")
                //distint() = todo lo que esta repetido no lo dejar repetir
                //evita el duplicado, lo quita de la lista u otro
                .distinct();

                nombres.forEach(System.out::println);



    }
}
