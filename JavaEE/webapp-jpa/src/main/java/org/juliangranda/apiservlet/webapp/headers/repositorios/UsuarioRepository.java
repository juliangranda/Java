package org.juliangranda.apiservlet.webapp.headers.repositorios;

import org.juliangranda.apiservlet.webapp.headers.models.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario> {
    Usuario porUsername(String username) throws Exception;
}
