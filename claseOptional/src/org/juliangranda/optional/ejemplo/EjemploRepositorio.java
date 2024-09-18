package org.juliangranda.optional.ejemplo;

import org.juliangranda.optional.ejemplo.models.Computador;
import org.juliangranda.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.juliangranda.optional.ejemplo.repositorio.Repositorio;

import java.util.Optional;

public class EjemploRepositorio {
    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        repositorio.filtrar("asus").ifPresentOrElse(System.out::println,
                ()-> System.out.println("No se encontro"));

//        Optional<Computador> pc = repositorio.filtrar("asus rog");
//        if(pc.isPresent()){
//            System.out.println(pc.get());
//        }else{
//            System.out.println("No se encontro");
//        }

    }
}
