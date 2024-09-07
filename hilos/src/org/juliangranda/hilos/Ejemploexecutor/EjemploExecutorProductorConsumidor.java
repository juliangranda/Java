package org.juliangranda.hilos.Ejemploexecutor;

import org.juliangranda.hilos.ejemplosync.Panaderia;
import org.juliangranda.hilos.ejemplosync.runnable.Consumidor;
import org.juliangranda.hilos.ejemplosync.runnable.Panadero;

import java.time.chrono.JapaneseDate;
import java.util.concurrent.*;

public class EjemploExecutorProductorConsumidor {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        //permite ejecutar varios Thread al mismo tiempo.
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        System.out.println("Tamaño del pool: "+ executor.getCorePoolSize());
        System.out.println("Cantidad de tareas en cola. "+executor.getQueue().size());

        Panaderia p = new Panaderia();
        Runnable productor = new Panadero(p);
        Runnable consumidor = new Consumidor(p);

        Future<?> futuro1 = executor.submit(productor);
        Future<?> futuro2 = executor.submit(consumidor);

        System.out.println("Tamaño del pool: "+ executor.getCorePoolSize());
        System.out.println("Cantidad de tareas en cola. "+executor.getQueue().size());

        executor.shutdown();
        System.out.println("Continuando con la ejecucion del metodo main");

    }
}
