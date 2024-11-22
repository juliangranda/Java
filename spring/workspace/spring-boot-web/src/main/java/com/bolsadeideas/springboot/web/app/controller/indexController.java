package com.bolsadeideas.springboot.web.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

//RequestMapping=ruta base que tienen en comun para todos los controladores.

@Controller
@RequestMapping("/app") 
public class indexController {

	//@RequestMapping(value="/index", method = RequestMethod.GET)
	@GetMapping({"/index", "/", "", "/home"})
	public String index(Model model) {
		model.addAttribute("titulo","Hola Spring Framework con Model");
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		
		Usuario usuario = new Usuario();
		usuario.setNombre("Julian");
		usuario.setApellido("Granda");
		usuario.setEmail("juliangranda@correo.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo","Perfil del usuario: "
				.concat(usuario.getNombre()));
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		List<Usuario> usuarios = new ArrayList<>();
		model.addAttribute("titulo","Listado de usuarios:");
		model.addAttribute("usuarios", usuarios);
		return "listar";
	}
}
