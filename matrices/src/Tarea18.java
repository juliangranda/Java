import java.util.Scanner;

public class Tarea18 {
    public static void main(String[] args) {
        String[][] matriz;
        int n = 0;
        Scanner s = new Scanner(System.in);
        System.out.println("ingrese el tamaño de una matriz nxn: ");
        n = s.nextInt();
        if(n==0){
            System.out.println("error no puede ingresar 0.");
            System.exit(1);
        }
        matriz = new String[n][n];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if(i==j || j==n-i-1){
                    matriz[i][j] = "X";
                }else {
                    matriz[i][j] = "_";
                }

            }
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
    }
}
