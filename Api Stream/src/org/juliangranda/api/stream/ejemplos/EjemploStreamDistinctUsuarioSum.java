package org.juliangranda.api.stream.ejemplos;

import org.juliangranda.api.stream.ejemplos.models.Usuario;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemploStreamDistinctUsuarioSum {
    public static void main(String[] args) {

        //Obtener un solo objeto.

        IntStream largonombres = Stream
                .of("Pato Guzman","Paco Gonzalez","Pepa Gutierrez ","Pepe Mena",
                        "Pepe Garcia","Pato Guzman","Pato Guzman")
                .map(nombre -> new Usuario(nombre.split(" ")[0],nombre.split(" ")[1]))
                .distinct()
                //convierte un map String a Int y retorna un IntStream.
                .mapToInt(u -> u.toString().length()) // u.getId()
                .peek(System.out::println);
                ;

        //largonombres.forEach(System.out::println);
        IntSummaryStatistics stats = largonombres.summaryStatistics();
        System.out.println("total: " + stats.getSum());
        System.out.println("max " + stats.getMax());
        System.out.println("Min() = " + stats.getMin());
        System.out.println("average " + stats.getAverage());
    }
}
