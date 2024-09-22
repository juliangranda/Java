package org.juliangranda.patrones.factory.producto;

import org.juliangranda.patrones.factory.PizzaProducto;

public class PizzaNewYorkPepperoni extends PizzaProducto {
    public PizzaNewYorkPepperoni() {
        super();
        nombre = "Pizza peperroni New York";
        masa = "Masa delgada a la piedra";
        salsa = "Salsa de Tomate";
        ingredientes.add("QUeso Mozzarella");
        ingredientes.add("Extra Pepperoni");
        ingredientes.add("Aceitunas");

    }

    @Override
    public void cocinar() {
        System.out.println("Cocinar por 40min,a 90°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortanto la pizza en triangulo");
    }
}
