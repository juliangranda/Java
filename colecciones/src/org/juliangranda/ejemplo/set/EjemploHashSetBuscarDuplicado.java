package org.juliangranda.ejemplo.set;

import java.util.*;

public class EjemploHashSetBuscarDuplicado {
    public static void main(String[] args) {

        String[] peces = {"Corvina","Lenguado","Pejerrey","Robalo","Atun","Lenguado"};

        Set<String> unicos = new HashSet<>();
        for(String pez:peces){
            //los que se agregar retornan un true pero los duplicados un false.
            //lo contrario a true se muestra.(duplicado)
            if(!unicos.add(pez)){
                System.out.println("Elemento duplicado: "+pez);
            }
        }
        System.out.println(unicos.size() + " elementos no duplicados "+ unicos);

    }
}
