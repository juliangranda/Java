package org.juliangranda.archivos.ejemplos;

import org.juliangranda.archivos.ejemplos.servicio.ArchivoServicio;

public class EjemploLeerArchivo {
    public static void main(String[] args) {
        String nombreArchivo = "C:\\cursos\\java\\archivos_clase_manejor_archivos\\java.txt";
        ArchivoServicio servicio = new ArchivoServicio();

        System.out.println(servicio.leerArchivo2(nombreArchivo));
    }
}
