import java.util.Scanner;

public class Tarea15 {
    public static void main(String[] args) {
        int[] numeros = new int[7];
        int promPos = 0;
        int contPos = 0;
        int promNeg = 0;
        int contNeg = 0;
        int numCeros = 0;

        Scanner s = new Scanner(System.in);
        for (int i = 0; i < numeros.length; i++){
            System.out.println("Ingrese un numero: ");
            numeros[i] = s.nextInt();
        }
        for(int i = 0; i < 7; i++){
            System.out.println("numeros: "+numeros[i]);
            if (numeros[i] > 0){
                promPos+= numeros[i];
                contPos++;
            } else if (numeros[i] < 0) {
                promNeg += numeros[i];
                contNeg++;
            } else if (numeros[i] == 0) {
                numCeros++;
            }
        }
        if (contPos > 0){
            System.out.println("Promedio numeros Positivos: "+ (float)promPos/contPos);
        }else{
            System.out.println("no se encuentran numeros positivos");
        }
        if (contNeg > 0){
            System.out.println("Promedio numeros Negativos: "+ (float)promNeg/contNeg);
        }else{
            System.out.println("No se encuentran numero negativos");
        }
        System.out.println("numeros que son 0: "+ numCeros);
    }
}
