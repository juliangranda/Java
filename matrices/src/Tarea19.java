import java.util.Scanner;

public class Tarea19 {
    public static void main(String[] args) {
        int n = 0;
        int[][] matriz;
        Scanner s = new Scanner(System.in);
        System.out.println("ingrese el tamaño nxn de la matriz: ");
        n = s.nextInt();
        matriz = new int[n][n];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                if (j == 0 || i == n / 2  || (j == n - 1 && i >= n / 2)) {
                    matriz[i][j] = 1;
                } else {
                    matriz[i][j] = 0;
                }
            }

            System.out.println();
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
    }
}
