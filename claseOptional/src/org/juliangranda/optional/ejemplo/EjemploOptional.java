package org.juliangranda.optional.ejemplo;

import java.util.Optional;

public class EjemploOptional {
    public static void main(String[] args) {

        /*
         * Optional: se utiliza para representar que un valor está presente
         *  o ausente. la principal caracteristica de Optional es que
         *  evita cualquier lanzamiento de la Exception,nullException
         *  en tiempo de ejecucion (unchecked).
         *
         * Evita el lanzamiento de la excepcion nullException
         * anidando o encapsulando el objeto dentro de la clase Optional,
         * además nos ayuda a desarrollar aplicaciones mucho mas
         * limpias y organizadas utilizando programacion funcional.
         * Un Optional también es un contenedor donde solo podemos
         * guardar como maximo un objeto/un solo valor.
         *
         * Ventajas;no se requiere controles de Null,no es necesario
         * validar con un if si el objeto es igual a null o tiene un valor.
         *
         */

        String nombre = "andres";
        Optional<String> opt = Optional.of(nombre);
        System.out.println("opt = " + opt);

        //isPresent para saber si el objeto esta presente o no (boolean)
        System.out.println(opt.isPresent());
        if(Optional.empty().isPresent()){
            //lo ideal es usar un opt.get() dentro de un condicional donde
            //Optional este presente.
            System.out.println("Hola " + opt.get());
        }
        System.out.println(opt.isEmpty());

        //programacion funcional con Optional.isPresent() como el condicional anterior.
        opt.ifPresent( valor -> System.out.println("Hola " + valor));

        nombre = null;
        //usamos Optional.ofNullable cuando no sabes si el objeto es null o no.
        opt = Optional.ofNullable(nombre);
        System.out.println("opt = " + opt);
        System.out.println(opt.isPresent());
        System.out.println(opt.isEmpty());

        //primer arg está presente, segundo arg no está presente.
        opt.ifPresentOrElse(valor -> System.out.println("hola "+valor),
                ()-> System.out.println("No esta presente"));

        //el condicional es lo mismo que el anterior metodo
        //isPresentOrElse
        if(opt.isPresent()){
            System.out.println("Hola " + opt.get());
        }else{
            System.out.println("No esta presente");
        }

        Optional<String> optEmpty = Optional.empty();
        System.out.println("optEmpty = " + optEmpty);
        System.out.println(optEmpty.isPresent());
    }
}
