import java.util.Scanner;

public class Tarea7 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num;
        int menor = 10;
        for (int i=0; i < 10; i++){
            System.out.println("ingrese el numero: "+i);
            num = scanner.nextInt();
            menor = (num < menor)? num:menor;
            if(menor < 10){
                System.out.println("El numero menor es menor que 10!");
            }else{
                System.out.println("El numero es igual o mayor que 10");
            }
        }
        System.out.println("el numero menor es = " + menor);
    }
}
