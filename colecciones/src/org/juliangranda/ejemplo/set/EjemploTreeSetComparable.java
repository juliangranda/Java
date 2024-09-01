package org.juliangranda.ejemplo.set;

import org.juliangranda.ejemplo.set.modelo.Alumno;

import java.util.Set;
import java.util.TreeSet;

import static java.util.Comparator.comparing;

public class EjemploTreeSetComparable {
    public static void main(String[] args) {
        //para TreeSet tiene que ser un objeto que utilice la interfaz Comparable en la clase(Alumno).

        //compareTo para dar un orden ascendente segun el nombre,nota u otro.
        Set<Alumno> sa = new TreeSet<>((a, b) -> b.getNota().compareTo(a.getNota()));

        sa.add(new Alumno("Pato", 5));
        sa.add(new Alumno("Cata", 6));
        sa.add(new Alumno("Luci", 4));
        sa.add(new Alumno("Jano", 7));
        sa.add(new Alumno("Andres", 3));
        sa.add(new Alumno("Zeus", 2));
        sa.add(new Alumno("Zeus", 8));
        System.out.println(sa);
    }
}
