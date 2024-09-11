package org.juliangranda.api.stream.ejemplos;

import org.juliangranda.api.stream.ejemplos.models.Usuario;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStreamFilterAnyMatch {
    public static void main(String[] args) {

        //AnyMatch: se utiliza para saber si existe o no existe
        //y retorna un booleano True o False pero No un objeto.

        //Es Boolean por que el retorno es booleano no un objeto.
        Boolean existe = Stream
                .of("Pato Guzman","Paco Gonzalez","Pepa Gutierrez ","Pepe Mena","Pepe Garcia")
                                            //posicion 0 el nombre, posicion 1 el apellido.
                .map(nombre -> new Usuario(nombre.split(" ")[0],nombre.split(" ")[1]))
                .peek(System.out::println)
                .anyMatch( u -> u.getId().equals(1))
                 ;

        System.out.println(existe);

        /*
        //todo el codigo siguiente es lo anterior pero con Steam y optimizado.
        List<Usuario> lista = Arrays.asList(
                new Usuario("Pato", "Guzman"),
                new Usuario("Paco", "Gonzalez"),
                new Usuario("Pepa", "Gutierrez "),
                new Usuario("Pepe", "Mena"),
                new Usuario("Pepe", "Garcia"));

        //las lineas siguientes es lo que reemplaza AnyMatch.
        boolean resultado = false;
        for(Usuario u: lista){
            if(u.getId().equals(3)){
                resultado = true;
                break;
            }
        }

        System.out.println(resultado);
        */

    }
}
