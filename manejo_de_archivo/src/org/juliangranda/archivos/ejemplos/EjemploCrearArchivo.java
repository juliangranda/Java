package org.juliangranda.archivos.ejemplos;

import org.juliangranda.archivos.ejemplos.servicio.ArchivoServicio;

public class EjemploCrearArchivo {
    public static void main(String[] args) {
        String nombreArchivo = "C:\\cursos\\java\\archivos_clase_manejor_archivos\\java.txt";

        ArchivoServicio service = new ArchivoServicio();
        service.crearArchivo(nombreArchivo);

    }
}
