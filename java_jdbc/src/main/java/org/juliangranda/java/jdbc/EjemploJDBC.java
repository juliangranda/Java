package org.juliangranda.java.jdbc;

import org.juliangranda.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;

//https://mvnrepository.com/   importante para dependencias
public class EjemploJDBC {
    public static void main(String[] args) {


        try(Connection conn = ConexionBaseDatos.getInstance();
            Statement stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM productos");) {

            while(resultado.next()){
                System.out.print(resultado.getInt("id"));
                System.out.print(" | ");
                System.out.print(resultado.getInt("precio"));
                System.out.print(" | ");
                System.out.print(resultado.getString("fecha_registro"));
                System.out.print(" | ");
                System.out.println(resultado.getString("nombre"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
