package org.juliangranda.archivos.ejemplos.servicio;

import java.io.*;

public class ArchivoServicio {


    //palabra FileWriter para escribir en un archivo.
    //añadiendo el segundo parametro en true nos permite anexar
    //mas contenido en el archivo.
    //Buffer nos permite anexar contenido adicional y es mas optimizada
    // debido al ahorro de recursos.
    public void crearArchivo(String nombre){

        //palabra File para crear archivos.
        File archivo = new File(nombre);
        //Al usar el BufferedWriter dentro del try() nos ahorramos el uso de close()
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(archivo, true))){

            //FileWriter escritor = new FileWriter(archivo, true);
            //BufferedWriter buffer = new BufferedWriter(escritor);
            buffer.append("Hola que tal amigos\n")
                    .append(" todo bien? yo aca escribiendo un archivo\n")
                    .append(" hasta luego lucas\n");
            //usar close() para cerrar el archivo( obligatorio para escribir en él)
            //buffer.close();
            System.out.println("El archivo se ha creado con exito");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void crearArchivo2(String nombre){

        File archivo = new File(nombre);
        try (PrintWriter buffer = new PrintWriter(new FileWriter(archivo, true))){

            buffer.println("Hola que tal amigos");
            buffer.println(" todo bien? yo aca escribiendo un archivo");
            //con formato usando printf
            buffer.printf(" hasta luego %s","Lucas" );

            System.out.println("El archivo se ha creado con exito");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
