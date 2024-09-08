package org.juliangranda.java8.lambda.tarea29;

public class FormateadorLambda {
    public static void main(String[] args) {

        //Clase Anonima - Interfaces

        //Tipo interfaz variable = parametro -> {cuerpo de funcion}
        Formatear fraseIn = frase -> {
            return frase.replace(",","")
                    .replace(" ","")
                    .replace(".","")
                    .toUpperCase();
        };

        String resultado = fraseIn.frase("Hola Buenos.Dias,Noches");
        System.out.println(resultado);

    }
}
