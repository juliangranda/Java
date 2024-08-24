package org.juliangranda.poointerfaces.imprenta;

import org.juliangranda.poointerfaces.imprenta.modelo.Curriculum;
import org.juliangranda.poointerfaces.imprenta.modelo.Hoja;
import org.juliangranda.poointerfaces.imprenta.modelo.Informe;

public class EjemploImprenta {
    public static void main(String[] args) {

        Curriculum cv = new Curriculum("Julian","Ingeniero Mecatronico","Resumen laboral....");
        cv.addExperiencias("Java");
        cv.addExperiencias("iot");
        cv.addExperiencias("Angular");

        Informe informe = new Informe("Martin Fowler", "James","Estudio sobre microservicios");
        imprimir(cv);
        imprimir(informe);
    }

    public static void imprimir(Hoja imprimible){
        System.out.println(imprimible.imprimir());
    }
}
