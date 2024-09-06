package org.juliangranda.hilos.ejemplo;

import org.juliangranda.hilos.ejemplo.runnable.ViajeTarea;

public class EjemploInterfaceRunnableJava8 {
    public static void main(String[] args) throws InterruptedException {

        /*
        *   sleep: depende de un tiempo, ademas toca calcular el tiempo que demora el thread en terminar.
            sleep es una pausa en el main
            sleep es estatico(static) está asociado a la clase o main.
            sleep al ser estatico se ejecuta por encima del thread por lo que resulta necesario calcular el tiempo de este.

            join: Espera a que terminen los demas thread, al terminar permite continuar con el resto del main/codigo.
            join se ejecuta con la instancia del Thread, esdecir, comienza y termina con el Thread.
        * */
        
        Thread main = Thread.currentThread();
        Runnable viaje = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " - " + Thread.currentThread().getName());
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Finalmente me voy de viaje a: " + Thread.currentThread().getName());
            System.out.println(main.getState());
        };
        Thread v1 = new Thread(viaje,"isla de pascua");
        Thread v2 = new Thread(viaje,"Robinson Crusoe");
        Thread v3 = new Thread(viaje,"Juan Fernando");
        Thread v4 = new Thread(viaje,"Isla de Chiloe");

        v1.start();
        v2.start();
        v3.start();
        v4.start();

        v1.join();
        v2.join();
        v3.join();
        v4.join();

        //Thread.sleep(1000);
        System.out.println("Continuando con la ejecucion del metodo main"+main.getName());
    }
}
