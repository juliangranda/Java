package com.bolsadeideas.springboot.web.app.controller;

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
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo","Perfil del usuario: "
				.concat(usuario.getNombre()));
		
		return "perfil";
	}
}
