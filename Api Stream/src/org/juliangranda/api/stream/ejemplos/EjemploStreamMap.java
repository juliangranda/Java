package org.juliangranda.api.stream.ejemplos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamMap {
    public static void main(String[] args) {

//        Stream<String> nombres = Stream
//                .of("Pato","Paco","Pepa","Pepe")
//                .map(nombre -> {
//                    return nombre.toUpperCase();
//                })
//                .peek(e -> { System.out.println(e); })
//                .map( e -> e.toLowerCase())
//                ;

//        peek(se usa para debugging o rastrear el stream),
//        para visualizar o saber como está quedando el stream
//        después de cada transformation u operación en éste,
//        ademas el peek() debe de ir después de dicha operación.

//          map() se usa para aplicar una operacion  especifica al Stream.

        Stream<String> nombres = Stream
                .of("Pato","Paco","Pepa","Pepe")
                .map(String::toUpperCase)
                .peek(System.out::println)
                .map(String::toLowerCase)
                ;


        //Convertir el Stream a una Lista
        //List<String> lista = nombres.collect(Collectors.toList());
        List<String> lista = nombres.toList();
        lista.forEach(System.out::println);

        //Steam no se ejecuta hasta que se invoca un metodo final( forEach ) u otro.
        //nombres.forEach(System.out::println);


    }
}
