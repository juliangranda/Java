package org.juliangranda.java.jdbc.repositorio;

import org.juliangranda.java.jdbc.model.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepositorioImpl implements Repositorio{

    private Connection conn;

    public CategoriaRepositorioImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List listar() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        try(Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM categorias")){
            while(rs.next()){
                categorias.add(crearCategoria(rs));
            }
        }
        return categorias;
    }

    @Override
    public Categoria porId(Long id) throws SQLException {
        Categoria categoria = null;
        try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM categorias as c WHERE c.id=?")){
            stmt.setLong(1, id);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    categoria = crearCategoria(rs);
                }
            }
        }
        return categoria;
    }

    @Override
    public Object guardar(Object categoria) throws SQLException {
        String sql = null;
        if(((Categoria)categoria).getId() != null && ((Categoria) categoria).getId() > 0){
            sql = "UPDATE categorias SET nombres=? WHERE id=?";
        }else{
            sql = "INSERT INTO categorias(nombre) VALUES(?)";
        }
        try(PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, ((Categoria) categoria).getNombre());
            if(((Categoria) categoria).getId() != null && ((Categoria) categoria).getId() > 0){
                stmt.setLong(2,((Categoria) categoria).getId());
            }
            stmt.executeUpdate();

            if(((Categoria) categoria).getId() == null){
                try(ResultSet rs = stmt.getGeneratedKeys()){
                    if(rs.next()){
                        ((Categoria) categoria).setId(rs.getLong(1));
                    }
                }
            }
        }

        return categoria;
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM categorias WHERE id=?")){
            stmt.setLong(1,id);
            stmt.executeUpdate();
        }
    }

    private static Categoria crearCategoria(ResultSet rs) throws SQLException {
        Categoria c = new Categoria();
        c.setId(rs.getLong("id"));
        c.setNombre(rs.getString("nombre"));
        return c;
    }
}
