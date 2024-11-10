package org.juliangranda.webapp.ear.services;

import jakarta.ejb.Local;
import org.juliangranda.webapp.ear.entities.Usuario;

import java.util.List;

@Local
public interface UsuarioService {
    List<Usuario> listar();
}
