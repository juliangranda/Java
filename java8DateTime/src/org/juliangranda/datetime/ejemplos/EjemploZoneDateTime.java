package org.juliangranda.datetime.ejemplos;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class EjemploZoneDateTime {
    public static void main(String[] args) {

        LocalDateTime fechaLocal = LocalDateTime.now();
        //cada pais tiene una Zone id buscar en wikipedia u otro.
        ZoneId newyork = ZoneId.of("America/New_York");
        ZonedDateTime zonaNy = ZonedDateTime.of(fechaLocal,newyork);
        System.out.println("Hora de partida new york: " + zonaNy);

        ZoneId madrid = ZoneId.of("Europe/Madrid");
        ZonedDateTime zonaMadrid = zonaNy.withZoneSameInstant(madrid).plusHours(8);
        System.out.println("hora llegada madrid: " + zonaMadrid);
    }
}
