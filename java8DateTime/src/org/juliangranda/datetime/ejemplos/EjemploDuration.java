package org.juliangranda.datetime.ejemplos;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class EjemploDuration {
    public static void main(String[] args) {

        LocalDateTime fecha1 = LocalDateTime.now();
        //fecha1 = fecha1.withMonth(10);
        LocalDateTime fecha2 = LocalDateTime.now().plusHours(3).plusMinutes(20).plusDays(1);

        //al imprimir la diferencia enter fechas : PT significa periodo de tiempo.
        Duration lapsos = Duration.between(fecha1, fecha2);
        System.out.println("lapsos = " + lapsos);
        System.out.println(lapsos.toMinutes());
        System.out.println("lapsos sumamos 5 horas= " + lapsos.plusHours(5));
    }
}
