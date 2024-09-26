package org.juliangranda.java.jdbc;

import org.juliangranda.java.jdbc.model.Categoria;
import org.juliangranda.java.jdbc.model.Producto;
import org.juliangranda.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.juliangranda.java.jdbc.repositorio.Repositorio;
import org.juliangranda.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

//https://mvnrepository.com/   importante para dependencias
public class EjemploJDBC {
    public static void main(String[] args) {


        try(Connection conn = ConexionBaseDatos.getInstance()) {

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("==========listar==============");
            repositorio.listar().forEach(System.out::println);

            System.out.println("==========obtener por id==============");
            System.out.println(repositorio.porId(1L));

            System.out.println("========== Insertar nuevo producto ==============");
            Producto producto = new Producto();
            producto.setNombre("Teclado Razer mecanico");
            producto.setPrecio(550);
            producto.setFechaRegistro(new Date());
            Categoria categoria = new Categoria();
            categoria.setId(3L);
            producto.setCategoria(categoria);
            repositorio.guardar(producto);
            System.out.println("Producto guardado con exito");

            repositorio.listar().forEach(System.out::println);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
