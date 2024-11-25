package com.bolsadeideas.springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		/*
		 * redirect: redirige/cambia la ruta url y recarga la pagina.
		 * forward: no recarga la pagina y no cambia la url 
		 * forward lo mas recomendado para una pagina inicio.
		 * */
		//return "redirect:https://www.google.com";
		//return "redirect:/app/index"; 
		return "forward:/app/index"; 
	}
}
