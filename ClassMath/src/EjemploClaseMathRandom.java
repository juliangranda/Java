import java.util.Random;

public class EjemploClaseMathRandom {
    public static void main(String[] args) {


        String[] colores = {"azul", "amarillo", "rojo", "verde", "blanco", "negro"};

        double random = Math.random();
        System.out.println("random = " + random);
        random *= colores.length; //limites del random.
        //random *= 7; donde 7 es el limite esdecir 0-7.

        System.out.println("random = " + random);

        random = Math.floor(random);
        System.out.println("random = " + random);

        //casting de double a int el numero random.
        System.out.println("colores = " + colores[(int) random]);
        
    }
}
