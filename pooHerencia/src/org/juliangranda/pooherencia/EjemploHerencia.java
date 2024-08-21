package org.juliangranda.pooherencia;

public class EjemploHerencia {
    public static void main(String[] args) {
        Alumno alumno = new Alumno();
        alumno.setNombre("Julian");
        alumno.setApellido("Gomez");
        Profesor profesor = new Profesor();
        profesor.setNombre("David");
        profesor.setApellido("Granda");
        profesor.setAsignatura("Matematicas");

        System.out.println(alumno.getNombre() + " " + alumno.getApellido());
        System.out.println("Profesor " + profesor.getAsignatura()
                + ", " + profesor.getNombre()
                + " " + profesor.getApellido());
    }


}
