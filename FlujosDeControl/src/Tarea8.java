import java.util.Scanner;

public class Tarea8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double notas;
        int contadorNotasM5 = 0;
        int contadorNotasD1 = 0;
        int contadorNotasM4 = 0;
        double notasMayoresA5 = 0;
        double notasMenoreA4 = 0;
        double promedioM5;
        double promedioM4;
        double promedioTotal;


        int maximo = 3;
        for (int i = 0; i < maximo; i++){
            System.out.println("Ingrese la nota final entre 1 a 7 del alumno:"+ (i+1));
            notas = scanner.nextDouble();
            if (notas == 0){
                System.out.println("Error finalizado el programa");
                break;
            }
            if (notas >= 5){
                contadorNotasM5++;
                notasMayoresA5 += notas;
            }else if(notas < 4){
                contadorNotasM4++;
                notasMenoreA4 += notas;
                if(notas == 1){
                    contadorNotasD1++;
                }
            }
        }
        promedioM5 = notasMayoresA5/contadorNotasM5;
        promedioM4 = notasMenoreA4/contadorNotasM4;
        promedioTotal = (notasMayoresA5+notasMenoreA4)/(contadorNotasM5+contadorNotasM4);
        System.out.println("promedioM5 = " + promedioM5);
        System.out.println("promedioM4 = " + promedioM4);
        System.out.println("contadorNotasD1 = " + contadorNotasD1);
        System.out.println("promedioTotal = " + promedioTotal);
    }
}
