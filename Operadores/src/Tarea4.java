import java.util.Scanner;

public class Tarea4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("ingrese el numero 1");
        int num1 = scanner.nextInt();
        System.out.println("ingrese el numero 2");
        int num2 = scanner.nextInt();
        String resultado = (num1 > num2)?
                num1 + " es mayor y " + num2 + " es menor":
                num2 + " es mayor y " + num1 + " es menor";
        System.out.println("resultado = " + resultado);
    }
}
