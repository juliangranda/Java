package org.juliangranda.java.jdbc;

import java.sql.*;

//https://mvnrepository.com/   importante para dependencias
public class EjemploJDBC {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/java_curso?serverTimeZone=UTC";
        String username = "root";
        String password ="admin";

        try(Connection conn = DriverManager.getConnection(url,username,password);
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
