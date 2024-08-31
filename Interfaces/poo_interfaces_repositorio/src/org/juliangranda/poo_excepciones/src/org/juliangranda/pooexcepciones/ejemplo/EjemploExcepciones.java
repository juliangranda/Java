package org.juliangranda.pooexcepciones.ejemplo;

import javax.swing.*;

public class EjemploExcepciones {
    public static void main(String[] args) {

        String valor = JOptionPane.showInputDialog("ingrese un entero: ");
        int divisor;
        try{
            divisor = Integer.parseInt(valor);
            int division = 10/ divisor;
            System.out.println(division);
        //la excepcion debe de ser lo mas específica posible no solo Excepcion hay otros tipos.
        }catch(NumberFormatException nfe){
            System.out.println("Se detecto una excepcion por favor ingese un valor numerico: "+ nfe.getMessage());
        }catch(ArithmeticException ae){
            System.out.println("Capturando la excepcion en tiempo de ejecucion: "+ae.getMessage());
            //main(args): ejecuta la excepcion hasta que ingresa el valor adecuado.
            main(args);
        }finally{
            System.out.println("Es opcional se ejecuta siempre con o sin excepcion");
        }
        System.out.println("Continuando con el flujo de nuestra aplicacion");

    }
}
