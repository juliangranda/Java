package org.juliangranda.optional.ejemplo;

import org.juliangranda.optional.ejemplo.models.Computador;
import org.juliangranda.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.juliangranda.optional.ejemplo.repositorio.Repositorio;

import java.util.Optional;

public class EjemploRepositorioMetodoOrElseThrow {
    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        //orElseThrow = se usa cuando la aplicacion necesita ser mas estricta
        //,si el objeto realmente no existe, no podemos continuar con la
        //ejecucion y necesitamos hacer alguna excepcion para
        //manejarla de alguna manera y para eso utilizamos este metodo.

        //orElseThrow() si no existe el objeto lanza una exception.
        Computador pc = repositorio.filtrar("rog").orElseThrow((IllegalAccessError::new));
        System.out.println(pc);

        String archivo = "documento.pdf";
        String extension = Optional.ofNullable(archivo)
                .filter(a -> a.contains("."))
                .map(a -> a.substring(archivo.lastIndexOf(".") + 1))
                .orElseThrow();
        System.out.println(extension);
    }

}
