package org.juliangranda.java8.lambda;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class EjemploConsumer {
    public static void main(String[] args) {

        //Consumer es una expresion lambda que nos permite pasar por
        //argumento un solo parametro del tipo generico.
        //y dentro de este metodo podemos implementar lo que queramos
        //o hacemos algo, el metodo es void no retorna nada.
        //al ser un argumento no es necesario los parentesis.
        Consumer<Date> consumidor = fecha -> {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(f.format(fecha));
        };
        //para ejecutar el consumidor(Consumer) - recibe el valor del tipo generico.
        consumidor.accept(new Date());

        //Consumer con dos parametros se conoce como BiConsumer.
        //Obligacion poner parentesis por ser dos argumentos.
        BiConsumer<String, Integer> consumidorBi = (nombre, edad) -> {
            System.out.println(nombre + ", tiene " + edad + " años");
        };
        consumidorBi.accept("pepe", 20);
    }
}
