package org.juliangranda.pooexcepciones.ejemplo;

import javax.swing.*;

public class EjemploExcepciones {
    public static void main(String[] args) {

        Calculadora cal = new Calculadora();
        String valor = JOptionPane.showInputDialog("ingrese un entero: ");
        int divisor;
        double division;
        try{
            divisor = Integer.parseInt(valor);
            division = cal.dividir(10, divisor);
            System.out.println(division);
        //la excepcion debe de ser lo mas específica posible no solo Excepcion hay otros tipos.
        }catch(NumberFormatException nfe){
            System.out.println("Se detecto una excepcion por favor ingese un valor numerico: "+ nfe.getMessage());
        }catch(DivisionPorZeroException ae){
            System.out.println("Capturando la excepcion en tiempo de ejecucion: "+ae.getMessage());
            //main(args): ejecuta la excepcion hasta que ingresa el valor adecuado.
            main(args);
        }finally{
            System.out.println("Es opcional se ejecuta siempre con o sin excepcion");
        }
        System.out.println("Continuando con el flujo de nuestra aplicacion");

    }
}
