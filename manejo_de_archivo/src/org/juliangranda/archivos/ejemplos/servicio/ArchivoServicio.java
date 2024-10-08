package org.juliangranda.archivos.ejemplos.servicio;

import java.io.*;
import java.util.Scanner;

public class ArchivoServicio {


    //palabra FileWriter para escribir en un archivo.
    //añadiendo el segundo parametro en true nos permite anexar
    //mas contenido en el archivo.
    //Buffer nos permite anexar contenido adicional y es mas optimizada
    // debido al ahorro de recursos.
    //Importante: siempre recordar el close()
    //sea de forma implicita dentro del try(recurso)(mejor)
    //o de forma explicita declarandolo en el codigo del try.
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


    public String leerArchivo(String nombre){
        StringBuilder sb = new StringBuilder();
        File archivo = new File(nombre);

        try(BufferedReader reader = new BufferedReader(new FileReader(archivo));) {
            //BufferedReader para leer archivos.
            String linea;
            while((linea = reader.readLine()) != null){
                sb.append(linea).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public String leerArchivo2(String nombre){
        StringBuilder sb = new StringBuilder();
        File archivo = new File(nombre);

        try(Scanner s = new Scanner(archivo)) {

            s.useDelimiter("\n");
            while(s.hasNext()){
                sb.append(s.next()).append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


}
