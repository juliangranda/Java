package org.juliangranda.pooexcepciones.ejemplo;

import javax.swing.*;

public class EjemploExcepciones {
    public static void main(String[] args) {

        Calculadora cal = new Calculadora();
        String numerador = JOptionPane.showInputDialog("ingrese un entero numerador: ");
        String denominador = JOptionPane.showInputDialog("ingrese un entero denominador: ");

        int divisor;
        double division;
        try{
            double division2 = cal.dividir(numerador,denominador);
            System.out.println("division2 = " + division2);
        //la excepcion debe de ser lo mas específica posible no solo Excepcion hay otros tipos.
        }catch (FormatoNumeroException e) {
            System.out.println("Se detecto la excepcion: ingrese numero valido: "+ e.getMessage());
            e.printStackTrace(System.out);
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
