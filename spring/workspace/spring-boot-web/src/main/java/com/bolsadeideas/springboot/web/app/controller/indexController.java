package com.bolsadeideas.springboot.web.app.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

//RequestMapping=ruta base que tienen en comun para todos los controladores.
//el controlador se encarga de manejar las peticiones del usuario.
//cada controlador va a manejar varios metodos que van a manejar una pagina distinta.
@Controller
@RequestMapping("/app") 
public class indexController {

	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	//requestmapping o getmapping son exactamente lo mismo.
	//@RequestMapping(value="/index", method = RequestMethod.GET)
	@GetMapping({"/index", "/", "", "/home"})
	public String index(Model model) {
		model.addAttribute("titulo",textoIndex);
		return "index"; 
		//debe de retormar una plantilla que se llame index.html
	}
	
	//usar model es lo mismo que ModelMap
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		
		Usuario usuario = new Usuario();
		usuario.setNombre("Julian");
		usuario.setApellido("Granda");
		usuario.setEmail("juliangranda@correo.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo",textoPerfil
				.concat(usuario.getNombre()));
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo",textoListar);
		return "listar";
	}
	
	//@ModelAttribute se usa para pasar datos,pero con la diferencia
	//que permite aplicar los datos a todos los metodos/vistas del controlador.
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = Arrays.asList(
				new Usuario("Julian","Granda","julian@correo.com"),
				new Usuario("Jhon","Doe","jhon@correo.com"),
				new Usuario("Jane","Doe","jane@correo.com"),
				new Usuario("Tornado","Roe","roe@correo.com"));
		
		return usuarios;
	}
}
