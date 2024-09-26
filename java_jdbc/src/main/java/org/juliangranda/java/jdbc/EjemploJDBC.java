package org.juliangranda.java.jdbc;

import org.juliangranda.java.jdbc.model.Producto;
import org.juliangranda.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.juliangranda.java.jdbc.repositorio.Repositorio;
import org.juliangranda.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;

//https://mvnrepository.com/   importante para dependencias
public class EjemploJDBC {
    public static void main(String[] args) {


        try(Connection conn = ConexionBaseDatos.getInstance()) {

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            repositorio.listar().forEach(p -> System.out.println(p.getNombre()));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
