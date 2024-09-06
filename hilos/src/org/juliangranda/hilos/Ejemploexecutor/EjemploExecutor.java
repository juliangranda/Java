package org.juliangranda.hilos.Ejemploexecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EjemploExecutor {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable tarea = () -> {
            System.out.println("inicio de la tarea.");
            try {
                System.out.println("nombre del thread: "+Thread.currentThread().getName());

                //parecido al sleep() pero automatizada la conversion.
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                //detener/interrumpir un Thread.
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            System.out.println("finaliza la tarea");
        };
        //submit = registro
        executor.submit(tarea);
        //apagar el executor.
        executor.shutdown();
        System.out.println("Continuando con la ejecucion del metodo main1");
        //espera a que finalizen todas las tareas y luego se detenga el
        // executor para continuar con la ejecucion del MAIN.
        executor.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("Continuando con la ejecucion del metodo main2");
    }
}
