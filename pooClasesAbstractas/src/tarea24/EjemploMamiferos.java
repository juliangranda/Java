package tarea24;

import tarea24.canino.*;
import tarea24.felino.*;

public class EjemploMamiferos {
    public static void main(String[] args) {
        Mamifero[] mamiferos = new Mamifero[5];

        Mamifero leon = new Leon("africa",3.1f,1.1f,60,5,30,5,80);
        Mamifero tigre = new Tigre("bosque",3.5f,1.5f,35,4,40,"bengala" );
        Mamifero lobo = new Lobo("tundra", 2.2f,1.2f,20,"blanco",3.5f,6,"Alpes" );
        Mamifero perro = new Perro("africa", 0.5f,0.5f,10,"naranjado",1.2f,40);
        Mamifero guepardo = new Guepardo("pradera",1.5f,0.8f,32,3,120 );

        mamiferos[0] = leon;
        mamiferos[1] = tigre;
        mamiferos[2] = lobo;
        mamiferos[3] = perro;
        mamiferos[4] = guepardo;

        for (Mamifero animal : mamiferos) {

            System.out.println(" =============== " + animal.getClass().getSimpleName() + " =============== ");
            System.out.println("Habitat:" + animal.getHabitat());
            System.out.println("Altura:" + animal.getAltura());
            System.out.println("Largo:" + animal.getLargo());
            System.out.println("Peso:" + animal.getPeso());
            System.out.println(animal.comer());
            System.out.println(animal.dormir());
            System.out.println(animal.correr());
            System.out.println(animal.comunicacion());
        }
    }
}



