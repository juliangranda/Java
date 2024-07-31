import java.util.Scanner;

public class ProgramaManejoDeNombres {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("ingrese nombre primer integrante");
        for (int i = 1; i <= 3; i++) {
            System.out.println("ingrese nombre integrante " + i);
            String integrante = scanner.nextLine();
            String SegundoCaracter = String.valueOf(integrante.toUpperCase().charAt(1)).concat(".");
            String resultado = integrante.substring(integrante.length() - 2);
            System.out.println("integrante " + i + ": " + SegundoCaracter + resultado);
        }
    }
}
