package org.juliangranda.api.stream.ejemplos;

import org.juliangranda.api.stream.ejemplos.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class EjemploStreamParallel {
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

        long t1= System.currentTimeMillis();
        String resultado = lista.stream()
                //los datos se procesen en un Thread separado de forma paralela
                // para hacerlo mas rapido y al mismo tiempo.
                //se usa cuando hay una gran cantidad de datos o cuando se demora la carga
                .parallel()
                .map(usuario -> usuario.toString().toUpperCase())
                .peek(n -> {
                    System.out.println("Nombre Thread: "+ Thread.currentThread().getName()
                    + " - " + n);
                })
                .flatMap(nombre -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if(nombre.contains("bruce".toUpperCase())){
                        return Stream.of(nombre);
                    }
                    return Stream.empty();
                    })
                        .findAny().orElse("");

        long t2 = System.currentTimeMillis();
        System.out.println("Tiempo total: " + (t2 - t1));
        System.out.println(resultado);

    }
}
