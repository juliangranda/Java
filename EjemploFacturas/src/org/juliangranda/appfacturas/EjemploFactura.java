package org.juliangranda.appfacturas;

import org.juliangranda.appfacturas.domain.Cliente;
import org.juliangranda.appfacturas.domain.Factura;
import org.juliangranda.appfacturas.domain.ItemFactura;
import org.juliangranda.appfacturas.domain.Producto;

import java.util.Scanner;

public class EjemploFactura {
    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.setNif("5555-5");
        cliente.setNombre("julian");
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese la descripcion de la factura: ");
        String desc = s.nextLine();
        Factura factura = new Factura(desc,cliente);

        Producto producto;
        String nombre;
        float precio;
        int cantidad;
        System.out.println();

        for (int i = 0; i < 5; i++) {
            producto = new Producto();
            System.out.print("Ingrese producto n"+ producto.getCodigo()+ ": ");
            nombre = s.nextLine();
            producto.setNombre(nombre);
            System.out.print("Ingrese el precio: ");
            precio = s.nextFloat();
            producto.setPrecio(precio);
            System.out.print("Ingrese la cantidad: ");
            cantidad = s.nextInt();

            ItemFactura item = new ItemFactura(cantidad, producto);
            factura.addItemFactura(item);

            System.out.println();
            s.nextLine();
        }
        System.out.println(factura.generarDetalle());
    }
}
