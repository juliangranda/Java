package org.juliangranda.datetime.ejemplos;

import java.time.LocalDate;
import java.time.Period;

public class EjemploPeriodo {
    public static void main(String[] args) {
        LocalDate fecha1 = LocalDate.of(2011,9,23);
        LocalDate fecha2 = LocalDate.of(2020,11,25);

//        metodo withMonth() se usa para cambiar el mes sin afectar la fecha usada,
//        pero es guardada en una nueva instancia/fecha donde preserva la inmutabilidad.
        LocalDate fecha3 = fecha2.withMonth(12);
        fecha3 = fecha3.withDayOfMonth(28);

        Period periodo = Period.between(fecha1,fecha3);
        System.out.println("periodo = " + periodo);

        System.out.printf("periodo entre %s y %s hay %d años, %d meses y %d dias",
                fecha1, fecha3, periodo.getYears(),periodo.getMonths(),periodo.getDays());
    }
}
