import java.util.Scanner;

public class CalcularAreaCirculo {
    public static void main(String[] args) {

        double radio;
        double area;

        System.out.println("ingrese el radio del circulo");
        Scanner scanner = new Scanner(System.in);
        radio = scanner.nextInt();
        area = Math.PI*Math.pow(radio,2);
        System.out.println("area = " + area);
    }
}
