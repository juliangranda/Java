package org.juliangranda.patrones.decorator2;

import org.juliangranda.patrones.decorator2.decorador.ConChocolateDecorador;
import org.juliangranda.patrones.decorator2.decorador.ConCremaDecorador;
import org.juliangranda.patrones.decorator2.decorador.ConLecheDecorador;

public class EjemploDecoradorCafe {
    public static void main(String[] args) {

        Configurable cafe = new Cafe("Cafe Mocha", 7 );
        ConCremaDecorador conCrema = new ConCremaDecorador(cafe);
        ConLecheDecorador conLeche = new ConLecheDecorador(conCrema);
        ConChocolateDecorador conChocolate = new ConChocolateDecorador(conLeche);
        System.out.println("EL precio del cafe mocha es:" + conChocolate.getPrecioBase());
        System.out.println("Los Ingredientes: " + conChocolate.getIngredientes());

        Configurable capuchino = new Cafe("Cafe capuchino", 4);
        conCrema = new ConCremaDecorador(capuchino);
        conLeche = new ConLecheDecorador(conCrema);
        System.out.println("El precio del capuchino es " + conLeche.getPrecioBase());
        System.out.println("Los ingredientes " + conLeche.getIngredientes());

        Configurable expresso = new Cafe("Cafe Expresso",3);
        System.out.println("El precio de Cafe expresso " + expresso.getPrecioBase());
        System.out.println("Los ingedientes del cafe Expresso es:" + expresso.getIngredientes());
    }
}
