package org.juliangranda.patrones.factory.producto;

import org.juliangranda.patrones.factory.PizzaProducto;

public class PizzaNewYorkItaliana extends PizzaProducto {

    public PizzaNewYorkItaliana() {
        super();
        nombre = "Pizza Italiana New York";
        masa = "masa Grande";
        salsa = "Salsa Italiana de Carne";
        ingredientes.add("Queso Mozzarella");
        ingredientes.add("Aceitunas");
        ingredientes.add("Jamon");
        ingredientes.add("Choricillo");
        ingredientes.add("Champiñones");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 30min a 120°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en triangulos grandes");
    }
}
