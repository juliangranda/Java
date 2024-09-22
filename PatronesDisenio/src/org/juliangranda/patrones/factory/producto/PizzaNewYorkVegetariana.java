package org.juliangranda.patrones.factory.producto;

import org.juliangranda.patrones.factory.PizzaProducto;

public class PizzaNewYorkVegetariana extends PizzaProducto {

    public PizzaNewYorkVegetariana() {
        super();
        nombre = " Pizza vegetariana NewYork";
        masa = "Masa integral vegana";
        salsa = "Salsa de Tomate";
        ingredientes.add("Queso Vegano");
        ingredientes.add("Tomate");
        ingredientes.add("Aceitunar");
        ingredientes.add("Espinacas");
        ingredientes.add("Berenjenas");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 25min, a 150°c ");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en rebanadas cuadradas");
    }
}
