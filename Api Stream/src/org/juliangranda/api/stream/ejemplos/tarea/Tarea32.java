package org.juliangranda.api.stream.ejemplos.tarea;

import java.util.Arrays;
import java.util.function.Function;

public class Tarea32 {
    public static void main(String[] args) {

        //Programacion Funcional con Api Stream.
        //elementos = arreglo
        Function<Integer[],Integer> max = elementos -> Arrays.stream(elementos)
                .reduce(0,(a,b)->{
                    int i = Math.max(a, b);
                    return i;
                });
        int resultado = max.apply(new Integer[]{3,25,22,10,5});
        System.out.println("resultado = " + resultado);
    }
}
