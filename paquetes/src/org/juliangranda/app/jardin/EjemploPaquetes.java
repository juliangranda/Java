package org.juliangranda.app.jardin;

import org.juliangranda.app.hogar.*;
import static org.juliangranda.app.hogar.ColorPelo.*;
import static org.juliangranda.app.hogar.Persona.*;
//nota: import static se usa para importar metodos o constantes estaticas de otras clases.
public class EjemploPaquetes {
    public static void main(String[] args) {
        Persona p = new Persona();
        p.setNombre("Andrés");
        p.setApellido("Guzmán");
        p.setColorPelo(CAFE);
        System.out.println(p.getNombre());

        Perro perro = new Perro();
        perro.nombre = "tobby";
        perro.raza = "Bulldog";

        String jugando = perro.jugar(p);
        System.out.println("jugando = " + jugando);
        String saludo = saludar();
        System.out.println("saludo = " + saludo);
        String generoMujer = GENERO_FEMENINO;
        String generoHombre = GENERO_MASCULINO;
    }
}

