package org.juliangranda.java.jdbc;

import org.juliangranda.java.jdbc.model.Categoria;
import org.juliangranda.java.jdbc.model.Producto;
import org.juliangranda.java.jdbc.repositorio.CategoriaRepositorioImpl;
import org.juliangranda.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.juliangranda.java.jdbc.repositorio.Repositorio;
import org.juliangranda.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJDBC {
    public static void main(String[] args) throws SQLException {

        try(Connection conn = ConexionBaseDatos.getConnection();) {
            if (conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            try {
                Repositorio<Categoria> repositorioCategoria = new CategoriaRepositorioImpl(conn);
                System.out.println("============ Insertar nueva categoria: ============");
                Categoria categoria = new Categoria();
                categoria.setNombre("Electrohogar");
                Categoria nuevacategoria = repositorioCategoria.guardar(categoria);
                System.out.println("Categoria guardado con exito: " + nuevacategoria.getId());

                Repositorio<Producto> repositorio = new ProductoRepositorioImpl(conn);
                System.out.println("==========listar==============");
                repositorio.listar().forEach(System.out::println);

                System.out.println("==========obtener por id==============");
                System.out.println(repositorio.porId(1L));

                System.out.println("========== Insertar nuevo producto ==============");
                Producto producto = new Producto();
                producto.setNombre("Refrigerador samsung");
                producto.setPrecio(9900);
                producto.setFechaRegistro(new Date());
                producto.setSku("abcdefg123");

                producto.setCategoria(nuevacategoria);
                repositorio.guardar(producto);
                System.out.println("Producto guardado con exito: " + producto.getId());

                repositorio.listar().forEach(System.out::println);
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw new RuntimeException(e);
            }
        }
    }
}
