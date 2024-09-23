package org.juliangranda.patrones.factory.producto;

import org.juliangranda.patrones.factory.PizzaProducto;

public class PizzaCaliforniaVegetariana extends PizzaProducto {

    public PizzaCaliforniaVegetariana() {
        super();
        nombre = "Pizza California Vegetariana";
        masa = "Masa delagada light";
        salsa = "Salsa BBQ Light";
        ingredientes.add("Queso Mozarella");
        ingredientes.add("Aceitunas");
        ingredientes.add("Espinacas");
        ingredientes.add("Cebolla");
        ingredientes.add("Berenjena");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 20min,a 180°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en rebanadas rectangulares");
    }
}
