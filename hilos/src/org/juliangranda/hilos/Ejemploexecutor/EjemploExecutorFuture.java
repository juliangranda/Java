package org.juliangranda.hilos.Ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

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
        //submit = registro

        //Future: Representa un resultado futuro de esta operacion asincrona,esta podria
        //devolver un resultado una vez finalice la tarea en el futuro.

        //Dato tipo Future el generico es dependiendo del tipo de retorno de la tarea.
        Future<String> resultadoFuturo = executor.submit(tarea);
        //apagar el executor.
        executor.shutdown();
        System.out.println("Continuando con la ejecucion del metodo main");

        //isDOne(): si esta hecha la tarea.
        //System.out.println(resultadoFuturo.isDone());
        while(!resultadoFuturo.isDone()){
            System.out.println("ejcutando tarea");
            TimeUnit.MILLISECONDS.sleep(1500);
        }

        //get() se bloquea hasta que finalice la tarea y retorna el resultado.(sleep)
        System.out.println("Obtenemos resultado tarea: " + resultadoFuturo.get());
        System.out.println("Finaliza la tarea " + resultadoFuturo.isDone());



    }
}
