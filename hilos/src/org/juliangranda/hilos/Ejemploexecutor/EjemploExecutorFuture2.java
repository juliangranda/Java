package org.juliangranda.hilos.Ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        //permite ejecutar varios Thread al mismo tiempo.
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<String> tarea = () -> {
            System.out.println("inicio de la tarea.");
            try {
                System.out.println("nombre del thread: "+Thread.currentThread().getName());

                //parecido al sleep() pero automatizada la conversion.
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                //detener/interrumpir un Thread.
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            System.out.println("finaliza la tarea");
            return "Algun resultado importante de la tarea";
        };

        Callable<Integer> tarea2 = () -> {
            System.out.println("Iniciando Tarea3");
            TimeUnit.SECONDS.sleep(3);
            return 10;
        };
        Future<String> resultadoFuturo = executor.submit(tarea);
        Future<String> resultado2 = executor.submit(tarea);
        Future<Integer> resultado3 = executor.submit(tarea2);

        executor.shutdown();
        System.out.println("Continuando con la ejecucion del metodo main");

        while(!(resultadoFuturo.isDone() && resultado2.isDone() && resultado3.isDone())){
            System.out.println(String.format("resultado1: %s - resultado2: %s - resultado3: %s",
                    resultadoFuturo.isDone()? "finalizó": "en proceso",
                    resultado2.isDone()? "finalizó": "en proceso",
                    resultado3.isDone()? "finalizó": "en proceso"));
            TimeUnit.MILLISECONDS.sleep(1000);
        }

        System.out.println("Obtenemos resultado tarea: " + resultadoFuturo.get());
        System.out.println("Finaliza la tarea " + resultadoFuturo.isDone());
        System.out.println("Obtenemos resultado tarea2: " + resultado2.get());
        System.out.println("Finaliza la tarea2 " + resultado2.isDone());
        System.out.println("Obtenemos resultado tarea3: " + resultado3.get());
        System.out.println("Finaliza la tarea3 " + resultado3.isDone());



    }
}
