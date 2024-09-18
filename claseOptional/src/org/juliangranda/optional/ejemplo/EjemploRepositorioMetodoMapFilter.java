package org.juliangranda.optional.ejemplo;

import org.juliangranda.optional.ejemplo.models.Computador;
import org.juliangranda.optional.ejemplo.models.Fabricante;
import org.juliangranda.optional.ejemplo.models.Procesador;
import org.juliangranda.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.juliangranda.optional.ejemplo.repositorio.Repositorio;

public class EjemploRepositorioMetodoMapFilter {
    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        //A partir de un computador->procesador->fabricante.
        String f = repositorio.filtrar("asus")
                .flatMap(Computador::getProcesador)
                .flatMap(Procesador::getFabricante)
                .filter(fab -> "Intel".equalsIgnoreCase(fab.getNombre()))
                .map(Fabricante::getNombre)
                .orElse("Desconocido");
        System.out.println(f);

        //importante: cuando retornamos un tipo Optional usamos flatmap()
        //retorna un tipo Stream pero cuando retornamos un objeto comun
        //utilizamos map().

    }
}
