package org.juliangranda.recursividad.ejemplos.mejorexplicacion;

public class RecursividadFactorial {
    public static void main(String[] args) {

        /*
        * La recursividad permite a las funciones llamarse a si mismas para
        * resolver un problema.
        *
        * las condiciones para su uso adecuado son:
        *   un Caso Base que proporciona una condicion terminal para evitar llamadas infinitas.
        *   un Caso Recursivo que reduce progresivamente el problema hacia el caso base(codigo).
        *
        * desventajas:
        *   lento,pierde en optimizacion, no puede ser aplicado a temas grandes, repite calculos.
        *
        * ejemplos de uso de recursividad fibonacci y factorial.
        *
        * (Se recomienda ver el video de recursividad de BettaTech)
        * */
        int num = 5;
        int resultadoFactorial = 0;
        resultadoFactorial = factorialRecursivo(5);
        System.out.println("resultadoFactorial = " + resultadoFactorial);

    }

    public static int factorialRecursivo(int numero){

        //Caso Base tiene 2 cosas: Caso Base para salir del ciclo y Caso Recursivo.

        if(numero == 0){
            return 1;
        }else{
            return numero * factorialRecursivo(numero - 1);
        }

    }
}
