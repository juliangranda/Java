package org.juliangranda.ejemplo.set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSet {
    public static void main(String[] args) {

        //TreeSet: tiene un costo de rendimiento por ser Ordenado.
        //un orden alfabetico/numerico y sin duplicados.

        //compareTo para darle un orden descendente.
        Set<String> ts = new TreeSet<>((a, b) -> b.compareTo(a));

        ts.add("uno");
        ts.add("dos");
        ts.add("tres");
        ts.add("tres");
        ts.add("cuatro");
        ts.add("cinco");

        System.out.println("ts = " + ts);

        //funcion Comparator.reverseOrder: para invertir el orden numerico.
        Set<Integer> numeros = new TreeSet<>(Comparator.reverseOrder());
        numeros.add(1);
        numeros.add(5);
        numeros.add(4);
        numeros.add(2);
        numeros.add(3);
        numeros.add(10);
        System.out.println("numeros = " + numeros);

    }
}
