package org.juliangranda.patrones.composite.Ejemplo;

import org.juliangranda.patrones.composite.Archivo;
import org.juliangranda.patrones.composite.Directorio;

public class EjemploCompositeBuscar {
    public static void main(String[] args) {

        Directorio doc = new Directorio("DOcumentos");
        Directorio java = new Directorio("Java");

        java.addComponente(new Archivo("Patron-composite.docx"));
        Directorio stream = new Directorio("Api Stream");
        stream.addComponente(new Archivo("Stream-map.docx"));

        java.addComponente(stream);

        doc.addComponente(java);
        doc.addComponente(new Archivo("cv.docx"));
        doc.addComponente(new Archivo("logo.png"));

        boolean encontrado = doc.buscar("Patron-composite.docx");
        System.out.println("Encontrado \"patron-composite.docx\":" + encontrado);

        encontrado = doc.buscar("Api Stream");
        System.out.println("Encontrado Api Stream: " + encontrado);
        //System.out.println(doc.mostrar(0));
        encontrado = doc.buscar("cv.docx");
        System.out.println("Encontrado cv.docx: " + encontrado);

    }
}
