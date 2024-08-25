package org.juliangranda.poointerface.dominio;

import org.juliangranda.poointerface.dominio.interfaces.*;

import java.util.Date;

public class ProyectoCatalogo {
    public static void main(String[] args) {

        Producto[] productos = new Producto[4];
        productos[0] = new IPhone(500,"Apple","Negro","Iphone15");
        productos[1] = new TvLcd(1200,"Sony",28);
        productos[2] = new Libro(100, new Date(),"Gabriel Garcia Marquez","100 años de soledad","AlphaOmega");
        productos[3] = new Comics(30,new Date(),"Stan Lee","Heroes","Marvel","IronMan");

        for(Producto producto: productos){
            System.out.print("Tipo de: " + producto.getClass().getName());
            System.out.print(" - ");
            System.out.print("Precio: " + producto.getPrecio());
            System.out.print(" - ");
            System.out.print("Precio final: " + producto.getPrecioVenta());

            // Para los Electronicos  ============
            if (producto instanceof IElectronico) {
                System.out.print(" - ");
                System.out.print("Fabricante: " + (((IElectronico) producto).getFabricante()));

                // Para los IPhone ============
                if (producto instanceof IPhone) {
                    System.out.print(" - ");
                    System.out.print("Modelo: " + ((IPhone) producto).getModelo());
                    System.out.print(" - ");
                    System.out.print("Color: " + ((IPhone) producto).getColor());
                }

                // Para los LCD  ============
                if (producto instanceof TvLcd) {
                    System.out.print(" - ");
                    System.out.print("Pulgadas: " + ((TvLcd) producto).getPulgada());
                }
            }

            // Para los Libros  ============
            if (producto instanceof ILibro) {
                System.out.print(" - ");
                System.out.print("Titulo: " + ((ILibro) producto).getTitulo());
                System.out.print(" - ");
                System.out.print("Autor: " + ((ILibro) producto).getAuthor());

                // Para los Comics  ============
                if (producto instanceof Comics) {
                    System.out.print(" - ");
                    System.out.print("Personaje: " + ((Comics) producto).getPersonaje());
                }

            }

            System.out.println();
        }
    }
}
