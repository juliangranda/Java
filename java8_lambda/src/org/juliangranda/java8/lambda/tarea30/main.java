package org.juliangranda.java8.lambda.tarea30;

import java.util.Collections;

public class main {
    public static void main(String[] args) {

        ContadorPalabra fraseContador = frase -> {

            String[] arreglo = frase.replace(",", "")
                    .replace(",", "")
                    .toLowerCase()
                    .split(" ");

            int max = 0;
            String palabra = null;

            for (int i = 0; i < arreglo.length; i++) {
                int cantidad = 0;
                for (int j = 0; j < arreglo.length; j++) {
                    if (arreglo[i].equalsIgnoreCase(arreglo[j])) {
                        cantidad++;
                    }
                }
                if (cantidad > max) {
                    max = cantidad;
                    palabra = arreglo[i];
                }
            }
            return Collections.singletonMap(palabra,max);
        };
        fraseContador.contadorPalabra("Yo ni te conozco, ni te he visto, ni se tu nombre, ni te hablaré, ni me interesas.")
                .forEach( (key,value) -> System.out.println("la palabra key: "+key +" -se repite: "+value));
        
    }
}
