package org.juliangranda.hilos.ejemplo;

import org.juliangranda.hilos.ejemplo.runnable.ViajeTarea;

public class EjemploInterfaceRunnableJava8 {
    public static void main(String[] args) {

        //instancia de un thread
        //es un thread usando java8 con funcion lambda para ser desacoplado.
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
        };
        new Thread(viaje,"isla de pascua").start();
        new Thread(viaje,"Robinson Crusoe").start();
        new Thread(viaje,"Juan Fernando").start();
        new Thread(viaje,"Isla de Chiloe").start();
    }
}
