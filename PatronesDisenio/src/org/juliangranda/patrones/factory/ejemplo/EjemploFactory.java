package org.juliangranda.patrones.factory.ejemplo;

import org.juliangranda.patrones.factory.PizzaProducto;
import org.juliangranda.patrones.factory.PizzeriaCaliforniaFactory;
import org.juliangranda.patrones.factory.PizzeriaNewYorkFactory;
import org.juliangranda.patrones.factory.PizzeriaZonaAbstractFactory;

public class EjemploFactory {
    public static void main(String[] args) {
        PizzeriaZonaAbstractFactory ny = new PizzeriaNewYorkFactory();
        PizzeriaZonaAbstractFactory california = new PizzeriaCaliforniaFactory();

        PizzaProducto pizza = california.ordenarPizza("queso");
        System.out.println("Bruce ordena la pizza "+pizza.getNombre());

        pizza = ny.ordenarPizza("pepperoni");
        System.out.println("Andres ordena una " + pizza.getNombre());

        pizza = california.ordenarPizza("vegetariana");
        System.out.println(pizza.getNombre());

        pizza = ny.ordenarPizza("vegetariana");
        System.out.println("linus ordena una " + pizza.getNombre());

        pizza = california.ordenarPizza("pepperoni");
        System.out.println("John ordena una " + pizza.getNombre());

        System.out.println("pizza = " + pizza);

    }
}
