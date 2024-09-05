package org.juliangranda.hilos.ejemplo.runnable;

public class EjemploInterfaceRunnable {
    public static void main(String[] args) {

        //instancia de un thread
        new Thread(new ViajeTarea("isla de pascua")).start();
        new Thread(new ViajeTarea("Robinson Crusoe")).start();
        new Thread(new ViajeTarea("Juan Fernando")).start();
        new Thread(new ViajeTarea("Isla de Chiloe")).start();
    }
}
