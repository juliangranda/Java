package org.juliangranda.java.jdbc;

import org.juliangranda.java.jdbc.model.Producto;
import org.juliangranda.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.juliangranda.java.jdbc.repositorio.Repositorio;
import org.juliangranda.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;

//https://mvnrepository.com/   importante para dependencias
public class EjemploJDBCDelete {
    public static void main(String[] args) {

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("==========listar==============");
            repositorio.listar().forEach(System.out::println);

            System.out.println("==========obtener por id==============");
            System.out.println(repositorio.porId(1L));

            System.out.println("========== Eliminar producto ==============");
            repositorio.eliminar(3L);
            System.out.println("Producto Eliminado con exito");

            repositorio.listar().forEach(System.out::println);

    }
}
