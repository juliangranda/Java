package org.juliangranda.ejemplo.set;


import java.util.HashSet;
import java.util.Set;

public class EjemploHashSetAgregar {
    public static void main(String[] args) {

        //Set: devuelve un booleano segun vayamos añadiendo los elementos,
        //son desordenados y no permite duplicados.
        Set<String> hs = new HashSet<>();
        System.out.println(hs.add("uno"));
        System.out.println(hs.add("dos"));
        System.out.println(hs.add("tres"));
        System.out.println(hs.add("cuatro"));
        System.out.println(hs.add("cinco"));

        System.out.println(hs);

        boolean b = hs.add("tres");
        System.out.println("permite elementos duplicados:"+b);
        System.out.println(hs);
    }
}
