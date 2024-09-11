package org.juliangranda.api.stream.ejemplos;

import org.juliangranda.api.stream.ejemplos.models.Usuario;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamFilterSingle {
    public static void main(String[] args) {

        //Obtener un solo objeto.

        Stream<Usuario> nombres = Stream
                .of("Pato Guzman","Paco Gonzalez","Pepa Gutierrez ","Pepe Mena","Pepe Garcia")
                                            //posicion 0 el nombre, posicion 1 el apellido.
                .map(nombre -> new Usuario(nombre.split(" ")[0],nombre.split(" ")[1]))
                .filter( u -> u.getNombre().equals("Pepe"))
                .peek(System.out::println)
                ;

        //Find: convertir nuestro flujo de datos a un solo objeto. el primer objeto en este caso.
        Optional<Usuario> usuario = nombres.findFirst();
        //obtener uno solo(objeto-usuario)
        System.out.println(usuario.get());


    }
}
