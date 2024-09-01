package org.juliangranda.ejemplo.set;

import org.juliangranda.ejemplo.set.modelo.Alumno;

import java.util.*;

public class EjemploHashSetUnicidad {
    public static void main(String[] args) {
        Set<Alumno> sa = new HashSet<>();
        // List<Alumno> sa = new LinkedList<>();
        sa.add(new Alumno("Pato", 5));
        sa.add(new Alumno("Cata", 6));
        sa.add(new Alumno("Luci", 4));
        sa.add(new Alumno("Jano", 7));
        sa.add(new Alumno("Andres", 3));
        sa.add(new Alumno("Zeus2", 2));
        sa.add(new Alumno("Zeus", 2));
        sa.add(new Alumno("Lucas", 2));
        sa.add(new Alumno("Lucas", 3));
        System.out.println(sa);


    }
}

