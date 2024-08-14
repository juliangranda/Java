import java.util.Scanner;

public class Tarea14 {
    public static void main(String[] args) {
        int[] numeros = new int[7];

        Scanner s = new Scanner(System.in);
        for (int i = 0; i < numeros.length; i++){
            System.out.println("Ingrese un numero entre 11-99: ");
            numeros[i] = s.nextInt();
        }
        int maximo = 0;
        for (int i = 0; i < numeros.length; i++)
        {
            maximo = (maximo > numeros[i]? maximo:numeros[i]);
        }
//        for (int n : numeros){
//            max = Math.max(n, maximo);
//        }
        System.out.println("el numero mayor del arreglo es: "+ maximo);
    }
}
