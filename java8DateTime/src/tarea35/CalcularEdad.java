package tarea35;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CalcularEdad {
    public static void main(String[] args) {

        System.out.println("Ingrese su fecha de cumpleaños: (año-mes-dia)");
        Scanner scanner = new Scanner(System.in);
        LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine(),DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Period anios = Period.between(fechaNacimiento, LocalDate.now());
        System.out.println("años = " + anios);
        System.out.printf("la persona tiene %d años, %d meses y %d dias",
                anios.getYears(),anios.getMonths(),anios.getDays());

        //---------------------------OTRA MANERA---------------------------

//        System.out.println("Ingrese su fecha de cumpleaños: (año-mes-dia)");
//        Scanner scanner = new Scanner(System.in);
//
//        LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine());
//        Period anios = Period.between(fechaNacimiento, LocalDate.now());
//        System.out.println("años = " + anios);
//        System.out.printf("la persona tiene %d años, %dmeses y %d dias",
//                anios.getYears(),anios.getMonths(),anios.getDays());

        //------------------------------------------------------------
        //usando ChronoUnit de la clase Ejemplo Local Date en donde se usa chrono Unit


//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Ingrese un fecha de nacimiento con formato yyyy-MM-dd:");
//        String fechaStr = scanner.next();
//
//        LocalDate fechaNacimiento = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        LocalDate actual = LocalDate.now();
//
//        long anios = ChronoUnit.YEARS.between(fechaNacimiento, actual);
//        System.out.printf("Tu edad es: %s años", anios);
    }
}
