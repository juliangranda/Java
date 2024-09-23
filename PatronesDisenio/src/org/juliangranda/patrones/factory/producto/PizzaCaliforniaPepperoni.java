package org.juliangranda.patrones.factory.producto;

import org.juliangranda.patrones.factory.PizzaProducto;

public class PizzaCaliforniaPepperoni extends PizzaProducto {
    public PizzaCaliforniaPepperoni() {
        super();
        nombre = "Pizza California Pepperoni";
        masa = "Masa a la piedra gruesa";
        salsa = "";
        ingredientes.add("Pepperoni");
        ingredientes.add("Extra Queso mozarella");
        ingredientes.add("Aceitunas");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando a 50min, a 55°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en pequeños rectangulos");
    }
}
