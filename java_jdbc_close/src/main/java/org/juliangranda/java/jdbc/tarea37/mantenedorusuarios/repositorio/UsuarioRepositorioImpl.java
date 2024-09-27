package org.juliangranda.java.jdbc.tarea37.mantenedorusuarios.repositorio;

import org.juliangranda.java.jdbc.tarea37.mantenedorusuarios.modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.juliangranda.java.jdbc.tarea37.mantenedorusuarios.util.ConexionBaseDatos.getConnection;

public class UsuarioRepositorioImpl implements IRepositorio<Usuario> {




    @Override
    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<>();

        try(Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT u.* FROM usuarios as u ")){
            while(rs.next()){
                Usuario u = crearUsuario(rs);
                usuarios.add(u);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuarios;
    }

    @Override
    public Usuario porId(Long id) {
        Usuario u = new Usuario();
        try(PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT u.* FROM usuarios as u " + "WHERE id=?" )) {
            stmt.setLong(1,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return u;
    }

    @Override
    public void guardar(Usuario usuario) {
        String sql;
        if((usuario.getId() != null) && (usuario.getId() > 0)){
            sql = "UPDATE usuarios SET username=?, password=?. email=? WHERE id=?";
        }else{
            sql = "INSERT INTO usuarios(username, password, email) VALUES(?,?,?)";
        }
        try(PreparedStatement stmt = getConnection().prepareStatement(sql)){
            stmt.setString(1, usuario.getUsername());
            stmt.setString(2,usuario.getPassword());
            stmt.setString(3, usuario.getEmail());

            if (usuario.getId() != null && usuario.getId()>0) {
                stmt.setLong(4,usuario.getId());
            }

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminar(Long id) {
        try(PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM usuarios WHERE id=?")){
            stmt.setLong(1,id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static Usuario crearUsuario(ResultSet rs) throws SQLException {
        Usuario u = new Usuario();
        u.setId(rs.getLong("id"));
        u.setUsername(rs.getString("username"));
        u.setPassword(rs.getString("password"));
        u.setEmail(rs.getString("email"));
        return u;
    }
}

