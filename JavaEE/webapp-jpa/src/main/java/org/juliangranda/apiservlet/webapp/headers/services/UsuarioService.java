package org.juliangranda.apiservlet.webapp.headers.services;

import org.juliangranda.apiservlet.webapp.headers.models.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> login(String username, String password);

    List<Usuario> listar();

    Optional<Usuario> porId(Long id);

    void guardar(Usuario usuario);

    void eliminar(Long id);
}
