package org.juliangranda.datetime.ejemplos;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class EjemploZoneDateTime {
    public static void main(String[] args) {

        LocalDateTime fechaLocal = LocalDateTime.parse("2021/09/23 12:45"
                , DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
        //cada pais tiene una Zone id buscar en wikipedia u otro.
        //ZonedDateTime zonaNy = ZonedDateTime.of(fechaLocal, ZoneOffset.of("-04:00"));

        //sin hacer uso del offset se usa ZoneId
        //ZoneId newyork = ZoneId.of("America/New_York");

        //haciendo uso del offset o utc(tiempo universal coordinado)
        ZonedDateTime zonaNy = fechaLocal.atZone(ZoneOffset.of("-04:00"));
        System.out.println("Hora de partida new york: " + zonaNy);

        //ZoneId madrid = ZoneId.of("Europe/Madrid");
        ZonedDateTime zonaMadrid = zonaNy.withZoneSameInstant(ZoneOffset.of("+02:00")).plusHours(8);
        System.out.println("hora llegada madrid: " + zonaMadrid);

        DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm, dd MMM yyyy");
        System.out.println("Detalles del viaje a españa");
        System.out.println("Partida NY: " + f.format(zonaNy));
        System.out.println("LLegada Madrid: " + f.format(zonaMadrid));

        //Muestra todas las ZOneIds disponibles.
        ZoneId.getAvailableZoneIds().forEach(System.out::println);

    }
}
