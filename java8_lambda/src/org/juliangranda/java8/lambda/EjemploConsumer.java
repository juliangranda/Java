package org.juliangranda.java8.lambda;

import org.juliangranda.java8.lambda.models.Usuario;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

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

        Consumer <String> consumidor2 = System.out::println;
        consumidor2.accept("hola mundo");

        List<String> nombres = Arrays.asList("andres","pepe","luz","paco");
        nombres.forEach(consumidor2);
        
        Supplier<Usuario> creaUsuario = Usuario::new;
        Usuario usuario = creaUsuario.get();

//        Usuario usuario = new Usuario();
//        BiConsumer<Usuario,String> asignarNombre = (persona, nombre) -> {
//            persona.setNombre(nombre);
//        };

        BiConsumer<Usuario,String> asignarNombre = Usuario::setNombre;
        asignarNombre.accept( usuario, "andres");
        System.out.println("nombre usuario: " + usuario.getNombre());

        //Supplier no recibe ningun argumento
        // y retorna un valor del tipo generic.
        Supplier<String> proveedor = () -> {
            return "Hola mundo lambda supplier";
        };
        //get() para obtener el valor de retorno.

        //Forma resumida al ser solo una linea omitiendo las llaves {}
        //Supplier<String> proveedor = () -> "Hola mundo lambda supplier";

        System.out.println(proveedor.get());
    }
}
