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
public class EjemploJDBCTrx {
    public static void main(String[] args) {


        try(Connection conn = ConexionBaseDatos.getInstance()) {

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("==========listar==============");
            repositorio.listar().forEach(System.out::println);

            System.out.println("==========obtener por id==============");
            System.out.println(repositorio.porId(1L));

            System.out.println("========== Insertar nuevo producto ==============");
            Producto producto = new Producto();
            producto.setNombre("Teclado IBM mecanico");
            producto.setPrecio(1550);
            producto.setFechaRegistro(new Date());
            Categoria categoria = new Categoria();
            categoria.setId(3L);
            producto.setCategoria(categoria);
            producto.setSku("abcde12345");
            repositorio.guardar(producto);
            System.out.println("Producto guardado con exito");

            System.out.println("========== Editar nuevo producto ==============");
            producto = new Producto();
            producto.setId(5L);
            producto.setNombre("Teclado Corsair k95 mecanico");
            producto.setPrecio(1000);
            producto.setSku("abcd123456");
             categoria = new Categoria();
            categoria.setId(1L);
            producto.setCategoria(categoria);
            repositorio.guardar(producto);
            System.out.println("Producto Actualizado con exito");

            repositorio.listar().forEach(System.out::println);

            repositorio.listar().forEach(System.out::println);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
