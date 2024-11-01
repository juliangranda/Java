package org.juliangranda.apiservlet.webapp.headers.repositorios;

import org.juliangranda.apiservlet.webapp.headers.models.Usuario;
import java.sql.SQLException;

public interface UsuarioRepository extends CrudRepository<Usuario> {
    Usuario porUsername(String username) throws SQLException;
}
