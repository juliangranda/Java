package org.juliangranda.poointerfaces.imprenta;

import org.juliangranda.poointerfaces.imprenta.modelo.*;

public class EjemploImprenta {
    public static void main(String[] args) {

        Curriculum cv = new Curriculum("Julian","Ingeniero Mecatronico","Resumen laboral....");
        cv.addExperiencias("Java");
        cv.addExperiencias("iot");
        cv.addExperiencias("Angular");

        Informe informe = new Informe("Martin Fowler", "James","Estudio sobre microservicios");

        Libro libro = new Libro("Erich Gamma", "Patrones de diseños: Elem. Reusables POO", Genero.PROGRAMACION);
        libro.addPagina(new Pagina("Patron Singleton"))
                .addPagina(new Pagina("Patron Observador"))
                .addPagina(new Pagina("Patron Factory"))
                .addPagina(new Pagina("Patron Composite"))
                .addPagina(new Pagina("Patron Facade"));

        imprimir(cv);
        imprimir(informe);
        imprimir(libro);
    }

    public static void imprimir(Imprimible imprimible){
        System.out.println(imprimible.imprimir());
    }
}
