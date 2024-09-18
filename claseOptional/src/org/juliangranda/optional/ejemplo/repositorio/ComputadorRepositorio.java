package org.juliangranda.optional.ejemplo.repositorio;

import org.juliangranda.optional.ejemplo.models.Computador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComputadorRepositorio implements Repositorio<Computador>{
    private List<Computador> dataSource;

    public ComputadorRepositorio() {
        dataSource = new ArrayList<>();
        dataSource.add(new Computador("Asus ROG","Strix 6512"));
        dataSource.add(new Computador("Macbook Pro","MVVK2CI"));
    }

    @Override
    public Optional<Computador> filtrar(String nombre) {
        return dataSource.stream()
                .filter(c -> c.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .findFirst();

//        for (Computador c: dataSource){
//            if(c.getNombre().equalsIgnoreCase(nombre)){
//                return Optional.of(c);
//            }
//        }
//        return Optional.empty();
    }
}
