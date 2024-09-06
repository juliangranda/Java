package org.juliangranda.hilos.ejemplo.sync;

import java.util.concurrent.SynchronousQueue;

public class Panaderia {
    private String pan;
    private boolean disponible;

    public synchronized void hornear(String masa){

        while(disponible){
            try {
                //Pone a esperar al Thread hasta que sea despertado
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.pan = masa;
        System.out.println("Panadero hornea: " + this.pan);
        this.disponible = true;
        //Despertamos el Thread que se encontraba esperando.
        notify();
    }

    public synchronized String consumir(){
        while(!disponible){
            try {
                //pone a esperar al Thread hasta que sea despertado.
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Cliente consume: " + this.pan);
        this.disponible = false;
        //Despierta el Thread que se encontraba esperando.
        notify();
        return pan;
    }
}
