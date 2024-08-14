import java.util.Scanner;

public class Tarea13 {
    public static void main(String[] args) {

        int[] numeros = new int[10];
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < numeros.length; i++){
            System.out.print("Ingrese 10 numeros:");
            numeros[i] = s.nextInt();

        }
        //5 es el equivalente al numero de opciones posicibles en 10 elementos.
        for (int i = 0; i < 5; i++)
        {
            System.out.println("numeros = " + numeros[9 - i]);
            System.out.println("numeros = " + numeros[i]);
        }
    }
}
