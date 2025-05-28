package com.bolsadeideas.springboot.error.app.domain.services;

import java.util.List;
import java.util.Optional;

import com.bolsadeideas.springboot.error.app.domain.Usuario;

public interface UsuarioService {

	public List<Usuario> listar();
	public Usuario obtenerPorId(Integer id);
	public Optional<Usuario> obtenerPorIdOptional(Integer id);
	
}
