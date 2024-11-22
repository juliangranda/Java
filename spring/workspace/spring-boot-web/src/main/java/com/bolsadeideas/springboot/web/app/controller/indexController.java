package com.bolsadeideas.springboot.web.app.controller;

import java.util.ArrayList;
import java.util.Arrays;
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
		List<Usuario> usuarios = Arrays.asList(new Usuario("Julian","Granda","julian@correo.com"),
				new Usuario("Jhon","Doe","jhon@correo.com"),
				new Usuario("Jane","Doe","jane@correo.com"),
				new Usuario("Tornado","Roe","roe@correo.com"));

		model.addAttribute("titulo","Listado de usuarios:");
		model.addAttribute("usuarios", usuarios);
		return "listar";
	}
}
