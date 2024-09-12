package org.juliangranda.api.stream.ejemplos;

import org.juliangranda.api.stream.ejemplos.models.Usuario;

import java.util.*;
import java.util.stream.Stream;

public class EjemploStreamListToStream {
    public static void main(String[] args) {


        List<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario("Andres","Guzman"));
        lista.add(new Usuario("Luci","Martinez"));
        lista.add(new Usuario("Pepe","Fernandez"));
        lista.add(new Usuario("cata","Perez"));
        lista.add(new Usuario("Lalo","Mena"));
        lista.add(new Usuario("Exequiel","Doe"));
        lista.add(new Usuario("Bruce","lee"));
        lista.add(new Usuario("Bruce","willis"));

        //Convierte la lista a un Stream<> = lista.steam().
        Stream<String> nombres = lista.stream()
                .map(usuario -> usuario.getNombre().toUpperCase()
                .concat(" ")
                .concat(usuario.getApellido().toUpperCase()))
                .flatMap(nombre -> {
                    if(nombre.contains("bruce".toUpperCase())){
                        return Stream.of(nombre);
                    }
                    return Stream.empty();
                    })
                .map(String::toLowerCase)
                .peek(System.out::println);

        System.out.println(nombres.count());

    }
}
