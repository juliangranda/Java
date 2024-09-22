package org.juliangranda.recursividad.ejemplos;

import org.juliangranda.recursividad.ejemplos.models.Componente;

public class EjemploRecursividad {
    public static void main(String[] args) {

        Componente pc = new Componente("Gabinete PC");
        Componente poder = new Componente("Fuente poder 788w");
        Componente placaMadre = new Componente("MainBoard Asus sockets AMD");
        Componente cpu = new Componente("CPU AMD Ryzen 5 2800");
        Componente ventilador = new Componente("Ventilador CPU");
        Componente disipador = new Componente("Disipador");
        Componente tv = new Componente("NVIDIA RTX 3600 8GB");
        Componente gpu = new Componente("Nvidia GPU RTX");
        Componente gpuRam = new Componente("4GB RAM");
        Componente gpuRam2 = new Componente("4GB RAM");
        Componente gpuVentiladores = new Componente("Ventailadores");
        Componente ram = new Componente("Memoria RAM 32GB");
        Componente ssd = new Componente("Disco ssd 2T");

        cpu.addComponente(ventilador)
                .addComponente(disipador);
        tv.addComponente(cpu).
                addComponente(gpuRam)
                .addComponente(gpuRam2)
                .addComponente(gpuVentiladores);
        placaMadre.addComponente(cpu)
                .addComponente(tv)
                .addComponente(ram)
                .addComponente(ssd);
        pc.addComponente(poder)
                .addComponente(placaMadre)
                .addComponente(new Componente("Teclado"))
                .addComponente(new Componente("Mouse"));




    }
}
