package org.juliangranda.hilos.ejemplo;

import org.juliangranda.hilos.ejemplo.runnable.ImprimirFrases;

public class EjemploSyncronizacionThread {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new ImprimirFrases("hola ","que tal")).start();
        new Thread(new ImprimirFrases("Quien eres ","tu?")).start();
        Thread.sleep(100);
        Thread h3 = new Thread(new ImprimirFrases("muchas", "gracias amigo"));
        h3.start();
        Thread.sleep(100);
        System.out.println(h3.getState());
    }

    public synchronized static void imprimirFrases(String frase1, String frase2){
        System.out.println(frase1);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(frase2);
    }
}
