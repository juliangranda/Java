package org.juliangranda.api.stream.ejemplos;

import java.util.stream.Stream;

public class EjemploStreamReduceInt {
    public static void main(String[] args) {

        Stream<Integer> nombres = Stream.of(5,10,15,20);

        //sumar elementos en un Steam
        int resultado = nombres.reduce(0, Integer::sum);
        System.out.println(resultado);



    }
}
