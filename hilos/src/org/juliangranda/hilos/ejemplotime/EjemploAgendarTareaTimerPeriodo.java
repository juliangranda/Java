package org.juliangranda.hilos.ejemplotime;

import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploAgendarTareaTimerPeriodo {
    public static void main(String[] args) {

        //toolkit cada que entramos a una tarea emite un sonido es un plus.
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        AtomicInteger contadorAtomic = new AtomicInteger(3);

        //timer: se utiliza para programar/agendar tareas.
        Timer timer = new Timer();

        //timerTask: termina la tarea despues de un tiempo.
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                int i = contadorAtomic.getAndDecrement();
                if( i > 0) {
                    //produce un sonido al entrar a la tarea usando toolkit.
                    toolkit.beep();
                    System.out.println("Tarea " + i + " periodica en:" + new Date() +
                            " nombre del Thread:" +
                            Thread.currentThread().getName());
                }else {
                    System.out.println("Finaliza el tiempo");
                    timer.cancel();
                }
            }
        }, 0, 10000);
        System.out.println("Agendamos una tarea inmediata y se repite cada 10segundos....");

    }
}
