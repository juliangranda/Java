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
                .filter( u -> u.getNombre().equals("Pepeb"))
                .peek(System.out::println)
                ;

        //Find: convertir nuestro flujo de datos a un solo objeto. el primer objeto en este caso.
        Optional<Usuario> usuario = nombres.findFirst();

        //obtener uno solo(objeto-usuario)
        //System.out.println(usuario.get());

        //metodo Optional .orElse = retorna un valor por defecto en caso de
        // no encontrar el valor que se busca al momento de comparar con equals con filter.
        //System.out.println(usuario.orElse(new Usuario("jhon","doe")).getNombre());

        //Optional .orElseGet= realiza lo mismo que el metodo anterior.
        //System.out.println(usuario.orElseGet(() -> new Usuario("jhon","doe")).getNombre());

        //.orElseThrow : si lo encuentra devuelve el objeto de lo contrario lanza una excepcion.
        //System.out.println(usuario.orElseThrow());

        //se omite la excepcion de los metodos anteriores por medio del uso del if.
        if(usuario.isPresent()) {
            System.out.println(usuario.get().getNombre());
        }else{
            System.out.println("No se encontro el objeto");
        }
    }
}
