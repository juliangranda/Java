package org.juliangranda.api.stream.ejemplos.tarea;

import java.util.Arrays;

public class Tarea31 {
    public static void main(String[] args) {

        int[] arreglo = new int[100];
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = i + 1;
        }

        double resultado = Arrays.stream(arreglo)
                .filter(e -> e % 10 != 0)
                .mapToDouble(e -> (double) e / 2)
                .reduce(0, Double::sum);

        System.out.println(resultado);






    }
}
