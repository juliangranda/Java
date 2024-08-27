package org.juliangranda.generics.src;

import org.juliangranda.poointerfaces.modelo.Cliente;
import org.juliangranda.poointerfaces.modelo.ClientePremium;

import java.util.*;

public class EjemploGenericos {
    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("julian","gomez"));

        Cliente julian = clientes.iterator().next();
        Cliente[] clientesArreglo = {new Cliente("Luci","martinez"),
                                    new Cliente("julian","gomez")};
        Integer[] enterosArreglo = {1,2,3};

        //Convertir un arreglo de tipo Clientea una lista.
        List<Cliente> clientesLista = fromArrayToList(clientesArreglo);

        //convertir un arreglo de enteros a una lista
        List<Integer> enterosLista = fromArrayToList(enterosArreglo);

        clientesLista.forEach(System.out::println);
        enterosLista.forEach(System.out::println);

        System.out.println("--------------------con 2 genericos-----------------");
        //Ejemplo para funcion con dos Genericos.
        //Con 1 solo arreglo va a convertir el arreglo a una lista,
        // pero si colocamos una coma y otro arreglo (2 parametros/genericos)
        // los va a imprimir y convertir ambos arreglos.

        List<String> nombres = fromArrayToList(new String[]{"andres","pepe",
                "luci","bea","jhon"}, enterosArreglo);
        nombres.forEach(System.out::println);

        List<ClientePremium> clientesPremiumList = fromArrayToList(
                new ClientePremium[]{new ClientePremium("paco", "fernandezz")});

        imprimirClientes(clientes);
        imprimirClientes(clientesLista);
        imprimirClientes(clientesPremiumList);

        System.out.println("Máximo de 1, 9 y 4 es: " + maximo(1, 9, 4));
        System.out.println("Máximo de 3.9, 11.6, 7.78 es: " + maximo(3.9, 11.6, 7.78));
        System.out.println("Máximo de zanahoria, arándanos, manzana es: "
                + maximo("zanahoria", "arándano", "manzana"));
    }

    public static <T> List<T> fromArrayToList(T[] c){
        //Array.asList: permite recibir un arreglo o convertirlo a uno.
        return Arrays.asList(c);
    }

    //<T extends Number> con extends especificamos el tipo de parametro
    // para un Generic(bounded Generic).
    public static <T extends Number> List<T> fromArrayToList(T[] c){
        //Array.asList: permite recibir un arreglo o convertirlo a uno.
        return Arrays.asList(c);
    }

    //El metodo trabaja con cualquier tipo que sea de tipo Cliente y
    //Subclases que heredan de esta clase,
    //ademas hacer uso de ("&") nos dice que: Cliente implemeneta una interfaz "Comparable".
    public static <T extends Cliente & Comparable<T>> List<T> fromArrayToList(T[] c){
        //Array.asList: permite recibir un arreglo o convertirlo a uno.
        return Arrays.asList(c);
    }

    public static <T, G> List<T> fromArrayToList(T[] c, G[] x){
        for(G elemento: x){
            System.out.println(elemento);
        }
        return Arrays.asList(c);
    }

    //comodines - wildcard Generics
    //permite que pasar a cualquier tipo de lista de tipo Cliente es decir
    // su descendencia, las clases hijas que heredan de la clase padre (Cliente).
    //añadiendo en el generico "?" y extends + Clase padre -> ( <? extends Clase ).
    public static void imprimirClientes(List<? extends Cliente> clientes){
        clientes.forEach(System.out::println);
    }

    public static <T extends Comparable<T>> T maximo(T a, T b, T c){
        T max = a;
        if(b.compareTo(max) > 0){
            max = b;
        }
        if(c.compareTo(max) > 0){
            max = c;
        }
        return max;
    }

}
