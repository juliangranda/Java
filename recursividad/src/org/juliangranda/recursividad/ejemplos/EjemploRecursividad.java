package org.juliangranda.recursividad.ejemplos;

import org.juliangranda.recursividad.ejemplos.models.Componente;

import java.util.stream.Stream;

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
        tv.addComponente(cpu)
                .addComponente(gpuRam)
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

        metodoRecursivoJava8(pc, 0).forEach(c -> System.out.println("\t".repeat(c.getNivel()) + c.getNombre()));

    }

    public static Stream<Componente> metodoRecursivoJava8(Componente c, int nivel){
        c.setNivel(nivel);
        return Stream.concat(Stream.of(c),
                c.getHijos().stream().flatMap(hijo -> metodoRecursivoJava8(hijo,nivel + 1)));


    }

    public static void metodoRecursivo(Componente c, int nivel){
        System.out.println("\t".repeat(nivel) + c.getNombre());
        if (c.tieneHijos()){
            for(Componente hijo: c.getHijos()){
                metodoRecursivo(hijo, nivel+1);
            }
        }
    }
}
