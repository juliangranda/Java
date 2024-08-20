package org.juliangranda.app;
//org o .com dependiendo del dominio y su nombre.
//app nombre del proyecto
import org.juliangranda.app.hogar.*;

public class EjemploPaquetes {
    public static void main(String[] args) {
        Persona persona = new Persona();
        persona.setApellido("julian");
        System.out.println(persona.getApellido());
        Gato g = new Gato();
        Perro p = new Perro();
    }
}
