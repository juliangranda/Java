package org.juliangranda.api.stream.ejemplos.tarea;

import java.util.Arrays;
import java.util.stream.Stream;

public class Tarea33 {
    public static void main(String[] args) {

        String[][] lenguajes = {{"java", "groovy"}, {"php"},
                {"c#", "python", "groovy"},
                {"java", "javascript", "kotlin"},
                {"javascript"}, {}};

        //aplanar un arreglo significa quitar los elementos repetidos
        //del arreglo y dejarlos en el arreglo de primer nivel.

        Arrays.stream(lenguajes)
                //aplanarlo a un solo nivel
                .flatMap(arreglo -> Arrays.stream(arreglo))
                //no permitir duplicados
                .distinct()
                .forEach(System.out::println);
    }
}
