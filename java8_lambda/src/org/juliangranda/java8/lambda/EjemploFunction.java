package org.juliangranda.java8.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;

public class EjemploFunction {
    public static void main(String[] args) {

        //Funcion es la mezcla entre Consumer y Supplier.
        //primer argumento es el tipo dato generico que se recibe y
        // el segundo es el tipo dato generico que retorna.

        //Function<String, String> f1 = param -> { return "Hola que tal" + param; };
        Function<String, String> f1 = param -> "Hola que tal " + param;
        String resultado = f1.apply("andres");
        System.out.println(resultado);

        //param.toUpperCase()
        Function<String,String> f2 = String::toUpperCase;
        System.out.println(f2.apply("andres"));

        //BiFunction = tiene dos argumentos y retorna uno.
        BiFunction<String, String, String> f3 = (a,b) -> a.toUpperCase().concat(b.toUpperCase());
        String r2 = f3.apply("andres","jose");
        System.out.println(r2);

        //(a,b) -> a.compareTo(b)
        BiFunction<String,String,Integer> f4 = String::compareTo;
        System.out.println(f4.apply("andres","andres"));
        //si son iguales ,resultado es 0,de lo contrario -1

        //(a,b) -> a.concat(b)
        BiFunction<String,String,String> f5 = String::concat;
        System.out.println(f5.apply("andres","jose"));
    }
}
