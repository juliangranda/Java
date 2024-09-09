package org.juliangranda.api.stream.ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.DoubleStream.builder;

public class EjemploStream {
    public static void main(String[] args) {

        //creacion del steam
        //Stream<String> nombres = Stream.of("Pato","Paco","Pepa","Pepe");

        //los tranformadores se encargan de realizar operaciones en el stream.
        //nombres.forEach(System.out::println);

//        String[] arr = { "Pato","Paco","Pepa","Pepe" };
//        Stream<String> nombres = Arrays.stream(arr);
//        nombres.forEach(System.out::println);

        /*Stream<String> nombres = Stream.<String>builder()
                .add("Pato")
                .add("Paco")
                .add("Pepa")
                .add("Pepe")
                .build();

        nombres.forEach(System.out::println);*/

        //usando Api Collections.
        List<String> lista = new ArrayList<>();
        lista.add("Pato");
        lista.add("Paco");
        lista.add("Pepe");
        lista.add("Pepa");

        //Stream<String> nombres = lista.stream();
        //nombres.forEach(System.out::println);

        lista.stream().forEach(System.out::println);

    }
}
