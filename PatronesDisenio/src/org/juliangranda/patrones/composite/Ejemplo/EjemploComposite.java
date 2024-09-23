package org.juliangranda.patrones.composite.Ejemplo;

import org.juliangranda.patrones.composite.Archivo;
import org.juliangranda.patrones.composite.Directorio;

public class EjemploComposite {
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

        System.out.println(doc.mostrar(0));
    }
}
