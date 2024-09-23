package org.juliangranda.patrones.factory.producto;

import org.juliangranda.patrones.factory.PizzaProducto;

public class PizzaCaliforniaQueso extends PizzaProducto {
    public PizzaCaliforniaQueso() {
        super();
        nombre = "Pizza California Queso";
        masa = "Masa a la piedra delgada";
        salsa = "Salsa de tomate rucula";
        ingredientes.add("Extra Queso mozarella");
        ingredientes.add("Cebolla");
        ingredientes.add("Queso Azul");

    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando a 35min, a 180°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en pequeños triangulos");
    }
}
