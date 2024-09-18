package org.juliangranda.optional.ejemplo;

import org.juliangranda.optional.ejemplo.models.Computador;
import org.juliangranda.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.juliangranda.optional.ejemplo.repositorio.Repositorio;

public class EjemploRepositorioMetodoOrElse {
    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        //orElse() = en caso de encontrar el objeto lo devuelve de lo contrario retorna
        // //un objeto por defecto.
        //Computador defecto = new Computador("HP Omen","LA0001");

        Computador pc = repositorio.filtrar("rog").orElse(valorDefecto());
        System.out.println(pc);

        //orElseGet() lo mismo que el metodo anterior pero este
        // recibe una expresion lambda de tipo supplier para crear/instanciar
        //el objeto por defecto.
        pc = repositorio.filtrar("macbook pro").orElseGet(EjemploRepositorioMetodoOrElse::valorDefecto);
        System.out.println(pc);

        //diferencia si o si es que el orElse() si o si siempre crea el
        //objeto por defecto ,es decir, un objeto redundante que ocupa
        //recursos que no vamos a utilizar.
        //el orElseGet esta optimizado y nunca va a llamar al objeto
        //por defecto en caso de que el objeto este presente.

    }

    public static Computador valorDefecto(){
        System.out.println("Obteniendo valor por defecto");
        return new Computador("HP Omen","LA0001");
    }

}
