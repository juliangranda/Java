package org.juliangranda.hilos.ejemplo;

import org.juliangranda.hilos.ejemplo.thread.NombreThread;

public class EjemploExtenderThread {
    public static void main(String[] args) throws InterruptedException {
        //crear una instancia del hilo
        Thread hilo  = new NombreThread("Jhon Doe");

        //inicia el hilo.usando start()
        hilo.start();
        //Thread.sleep: para una pequeña pausa del hilo.
        //Thread.sleep(100);
        Thread hilo2 = new NombreThread("julian");
        hilo2.start();

        Thread hilo3 = new NombreThread(("david"));
        hilo3.start();
        System.out.println(hilo.getState());
    }
}
