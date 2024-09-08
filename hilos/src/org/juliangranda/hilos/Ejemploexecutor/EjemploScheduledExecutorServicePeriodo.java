package org.juliangranda.hilos.Ejemploexecutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploScheduledExecutorServicePeriodo {
    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        System.out.println("Alguna tarea en el main");

        //se bloquea despues de realizar la tarea 5 o n veces la tarea.
        AtomicInteger contador = new AtomicInteger(5);
        //CountDownLatch lock = new CountDownLatch(5);
        Future<?> future = executor.scheduleAtFixedRate(() -> {
            System.out.println("Hola mundo Tarea...");
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                //lock.countDown();
                contador.getAndDecrement();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        },1000,2000, TimeUnit.MILLISECONDS);

        //lock.await();
        //future.cancel(true);
        //TimeUnit.SECONDS.sleep(10);
        while(contador.get() >= 0){
            if(contador.get() == 0){
                future.cancel(true);
                contador.getAndDecrement();
            }
        }
        System.out.println("Alguna otra tarea en el main...");
        executor.shutdown();
    }
}
