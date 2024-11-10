package org.juliangranda.webapp.ear.repositories;

import org.juliangranda.webapp.ear.entities.Usuario;

import java.util.List;

public interface UsuarioRepository {
    List<Usuario> listar();
}
