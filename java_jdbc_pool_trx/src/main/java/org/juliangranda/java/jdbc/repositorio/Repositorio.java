package org.juliangranda.java.jdbc.repositorio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

//tema de consulta y operaciones de la base de datos.
//CRUD - DAO/Repositorio.
public interface Repositorio<T> {

    void setConn(Connection conn);

    List<T> listar() throws SQLException;

    T porId(Long id) throws SQLException;

    T guardar(T t) throws SQLException;

    void eliminar(Long id) throws SQLException;


}
