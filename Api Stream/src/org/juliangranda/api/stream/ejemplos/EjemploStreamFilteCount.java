package org.juliangranda.api.stream.ejemplos;

import org.juliangranda.api.stream.ejemplos.models.Usuario;

import java.util.stream.Stream;

public class EjemploStreamFilteCount {
    public static void main(String[] args) {

        //count: no recibe argumento y retorna la cantidad de elementos en el stream.
        //retorna un tipo long no int.
        long count = Stream
                .of("Pato Guzman","Paco Gonzalez","Pepa Gutierrez ","Pepe Mena","Pepe Garcia")
                                            //posicion 0 el nombre, posicion 1 el apellido.
                .map(nombre -> new Usuario(nombre.split(" ")[0],nombre.split(" ")[1]))
                .peek(System.out::println)
                .count()
                 ;

        System.out.println(count);
         
    }
}
