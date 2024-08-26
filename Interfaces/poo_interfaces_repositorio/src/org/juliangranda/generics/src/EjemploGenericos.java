package org.juliangranda.generics.src;

import org.juliangranda.poointerfaces.modelo.Cliente;
import org.juliangranda.poointerfaces.modelo.ClientePremium;

import java.util.*;

public class EjemploGenericos {
    public static void main(String[] args) {

        List<Cliente> cliente = new ArrayList<>();
        cliente.add(new Cliente("julian","gomez"));

        Cliente julian = cliente.iterator().next();
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

        List<ClientePremium> clientesPremiumList = fromArrayToList(new ClientePremium[]{new ClientePremium("paco", "fernandezz")});

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


}
