package org.juliangranda.hilos.ejemplotime;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class EjemploAgendarTareaTimer {
    public static void main(String[] args) {

        //timer: se utiliza para programar/agendar tareas.
        Timer timer = new Timer();

        //timerTask: termina la tarea despues de un tiempo.
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Tarea realizada en:" + new Date() +
                        " nombre del Thread:" +
                        Thread.currentThread().getName());
                System.out.println("Finaliza el tiempo");
                timer.cancel();
            }
        }, 5000);

        System.out.println("Agendamos una tarea para 5 minutos mas....");

    }
}
