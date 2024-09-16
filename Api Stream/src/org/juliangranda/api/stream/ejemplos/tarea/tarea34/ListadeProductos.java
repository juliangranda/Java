package org.juliangranda.api.stream.ejemplos.tarea.tarea34;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ListadeProductos {
    public static void main(String[] args) {

        List<Producto> facturas = Arrays.asList(new Producto(9.99,1));
        List<Producto> listaproductos = new ArrayList<>();

        listaproductos.add(new Producto(12.3,2));
        listaproductos.add(new Producto(15.5,1));
        listaproductos.add(new Producto(5.9,6));

        double importes = listaproductos.stream()
                .map(p -> (p.getCantidad()* p.getPrecio()) )
                .reduce(0d, Double::sum);
        System.out.println("importes = " + importes);


    }
}
