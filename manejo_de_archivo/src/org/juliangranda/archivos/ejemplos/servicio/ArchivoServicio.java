package org.juliangranda.archivos.ejemplos.servicio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ArchivoServicio {

    public void crearArchivo(String nombre){

        //palabra File para crear archivos.
        File archivo = new File(nombre);

        try {
            //palabra FileWriter para escribir en un archivo.
            //añadiendo el segundo parametro en true nos permite anexar
            //mas contenido en el archivo.
            FileWriter escritor = new FileWriter(archivo, true);
            escritor.append("Hola que tal amigos\n")
                    .append(" todo bien? yo aca escribiendo un archivo\n")
                    .append(" hasta luego lucas\n");
            //usar close() para cerrar el archivo( obligatorio para escribir en él)
            escritor.close();
            System.out.println("El archivo se ha creado con exito");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
