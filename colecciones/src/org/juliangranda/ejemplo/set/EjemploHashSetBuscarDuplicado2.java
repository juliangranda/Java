package org.juliangranda.ejemplo.set;

import java.util.HashSet;
import java.util.Set;

public class EjemploHashSetBuscarDuplicado2 {
    public static void main(String[] args) {

        String[] peces = {"Corvina","Atún","Lenguado","Pejerrey","Robalo","Atún","Lenguado"};

        Set<String> unicos = new HashSet<>();
        Set<String> duplicados = new HashSet<>();
        for(String pez:peces){
            //los que se agregar retornan un true pero los duplicados un false.
            //lo contrario a true se muestra.(duplicado)
            if(!unicos.add(pez)){
                duplicados.add(pez);
            }
        }

        unicos.removeAll(duplicados);

        System.out.println("unicos: " + unicos);
        System.out.println("Duplicados: " + duplicados);

    }
}
