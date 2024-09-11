package org.juliangranda.api.stream.ejemplos;

import org.juliangranda.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamFilterSingle2 {
    public static void main(String[] args) {

        //filter: se encarga de filtrar en un Steam o en el flujo de datos.
        
        //Obtener un solo objeto.

        //Find: convertir nuestro flujo de datos a un solo objeto. el primer objeto en este caso.
        //obtener uno solo(objeto-usuario)

        Usuario usuario = Stream
                .of("Pato Guzman","Paco Gonzalez","Pepa Gutierrez ","Pepe Mena","Pepe Garcia")
                                            //posicion 0 el nombre, posicion 1 el apellido.
                .map(nombre -> new Usuario(nombre.split(" ")[0],nombre.split(" ")[1]))
                .peek(System.out::println)
                .filter( u -> u.getId().equals(2))
                .findFirst().get()
                ;

        System.out.println(usuario);


    }
}
