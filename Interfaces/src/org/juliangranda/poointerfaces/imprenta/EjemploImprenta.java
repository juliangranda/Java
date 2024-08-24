package org.juliangranda.poointerfaces.imprenta;

import org.juliangranda.poointerfaces.imprenta.modelo.*;

public class EjemploImprenta {
    public static void main(String[] args) {

        Curriculum cv = new Curriculum(new Persona("Jhon","Doe"),
                "Ingeniero Mecatronico","Resumen laboral....")
                .addExperiencias("Java")
                .addExperiencias("iot")
                .addExperiencias("Angular");

        Libro libro = new Libro(new Persona("Erich","Gamma"),
                "Patrones de diseños: Elem. Reusables POO", Genero.PROGRAMACION);
        libro.addPagina(new Pagina("Patron Singleton"))
                .addPagina(new Pagina("Patron Observador"))
                .addPagina(new Pagina("Patron Factory"))
                .addPagina(new Pagina("Patron Composite"))
                .addPagina(new Pagina("Patron Facade"));

        Informe informe = new Informe(new Persona("Martin","Fowler"),
                new Persona("James","Gosling"),
                "Estudio sobre microservicios");

        imprimir(cv);
        imprimir(informe);
        imprimir(libro);
    }

    public static void imprimir(Imprimible imprimible){
        System.out.println(imprimible.imprimir());
    }
}
