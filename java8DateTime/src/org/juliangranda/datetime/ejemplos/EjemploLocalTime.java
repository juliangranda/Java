package org.juliangranda.datetime.ejemplos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class EjemploLocalTime {
    public static void main(String[] args) {

        LocalTime ahora = LocalTime.now();
        System.out.println("ahora = " + ahora);
        System.out.println("Hora: " + ahora.getHour());
        System.out.println("Minutos: " + ahora.getMinute());
        System.out.println("Segundos: " + ahora.getSecond());
        System.out.println("NanoSegundos: " + ahora.getNano());

        LocalTime seisConTreinta = LocalTime.of(6,30,59);
        System.out.println("seisConTreinta = " + seisConTreinta);
        seisConTreinta = LocalTime.parse("18:30:45");

        System.out.println("seisConTreinta = " + seisConTreinta);
        LocalTime sieteConTreinta = LocalTime.of(6,30).plus(1, ChronoUnit.HOURS);
        System.out.println("sieteConTreinta = " + sieteConTreinta);


        boolean esAnterior = LocalTime.of(6,30,59).isBefore(LocalTime.parse("07:30"));
        System.out.println("esAnterior = " + esAnterior);

        //si se usa HH en mayuscual se trabaja con 24horas - " a " muestra Am o PM.
        DateTimeFormatter df = DateTimeFormatter.ofPattern("hh:mm:ss a");
        String ahoraFormateado = seisConTreinta.format(df);
        System.out.println(ahoraFormateado);

        ahoraFormateado = df.format(ahora);
        System.out.println("ahoraFormateado = " + ahoraFormateado);

        LocalTime max = LocalTime.MAX;
        LocalTime min = LocalTime.MIN;

        //hora minima y maxima
        System.out.println("max = " + max);
        System.out.println("min = " + min);



    }
}
