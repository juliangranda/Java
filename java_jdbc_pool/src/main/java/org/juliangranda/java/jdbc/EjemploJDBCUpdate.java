package org.juliangranda.java.jdbc;

import org.juliangranda.java.jdbc.model.Categoria;
import org.juliangranda.java.jdbc.model.Producto;
import org.juliangranda.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.juliangranda.java.jdbc.repositorio.Repositorio;
import org.juliangranda.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

//https://mvnrepository.com/   importante para dependencias
public class EjemploJDBCUpdate {
    public static void main(String[] args) {

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("==========listar==============");
            repositorio.listar().forEach(System.out::println);

            System.out.println("==========obtener por id==============");
            System.out.println(repositorio.porId(1L));

            System.out.println("========== Editar nuevo producto ==============");
            Producto producto = new Producto();
            producto.setId(6L);
            producto.setNombre("Teclado Corsair k95 mecanico");
            producto.setPrecio(700);
            Categoria categoria = new Categoria();
            categoria.setId(1L);
            producto.setCategoria(categoria);
            repositorio.guardar(producto);
            System.out.println("Producto Actualizado con exito");

            repositorio.listar().forEach(System.out::println);

    }
}
