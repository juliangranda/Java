package org.juliangranda.ejemplo.map;

import java.util.*;

public class EjemploHashMap {
    public static void main(String[] args) {

        //Map(key,obj)
        Map<String, String> persona = new HashMap<>();

        //guardar valor/elemento se usa "put".
        //las llaves/keys en HasMap son unicas nunca se repiten y solo puede haber un llave "null"..
        persona.put(null, "1234");
        persona.put(null, "12345");
        persona.put("nombre", "John");
        persona.put("apellido", "Doe");
        persona.put("apellidoPaterno", "Doe");
        persona.put("email", "john.doe@email.com");
        persona.put("edad", "30");

        System.out.println("persona = " + persona);

        //obtener el valor de una key.
        String nombre = persona.get("nombre");
        System.out.println("nombre = " + nombre);
        String apellido = persona.get("apellido");
        System.out.println("apellido = " + apellido);


    }
}
