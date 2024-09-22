package org.juliangranda.patrones.factory;

import org.juliangranda.patrones.factory.producto.PizzaNewYorkItaliana;
import org.juliangranda.patrones.factory.producto.PizzaNewYorkPepperoni;
import org.juliangranda.patrones.factory.producto.PizzaNewYorkVegetariana;

public class PizzeriaNewYorkFactory extends PizzeriaZonaAbstractFactory{


    @Override
    PizzaProducto crearPizza(String tipo) {
        PizzaProducto producto = null;
        switch (tipo){
            case "vegetariana":
                producto = new PizzaNewYorkVegetariana();
                break;
            case "pepperoni":
                producto = new PizzaNewYorkPepperoni();
                break;
            case "italiana":
                producto = new PizzaNewYorkItaliana();
                break;

        }
        return producto;
    }
}
