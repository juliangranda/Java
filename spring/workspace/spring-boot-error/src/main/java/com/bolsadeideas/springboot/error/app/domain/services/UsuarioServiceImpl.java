package com.bolsadeideas.springboot.error.app.domain.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.error.app.domain.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private List<Usuario> lista;
	
	
	public UsuarioServiceImpl() {
		this.lista = new ArrayList<>();
		this.lista.add(new Usuario(1,"andres","guzman"));
		this.lista.add(new Usuario(2,"Pepa","Garcia"));
		this.lista.add(new Usuario(3,"Lalo","Mena"));
		this.lista.add(new Usuario(4,"Luci","Fernandez"));
		this.lista.add(new Usuario(5,"Pato","Gonzalez"));
		this.lista.add(new Usuario(6,"Paco","rodriguez"));
		this.lista.add(new Usuario(7,"Juan","Gomez"));
	}

	@Override
	public List<Usuario> listar() {
		return this.lista;
	}

	@Override
	public Usuario obtenerPorId(Integer id) {
		Usuario resultado = null;
		for(Usuario u: this.lista) {
			if(u.getId().equals(id)) {
				resultado = u;
				break;
			}
		}
		return resultado;
	}
	
	@Override
	public Optional<Usuario> obtenerPorIdOptional(Integer id) {
		Usuario usuario = this.obtenerPorId(id);
		return Optional.ofNullable(usuario);
	}
}
