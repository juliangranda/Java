package com.bolsadeideas.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsadeideas.springboot.di.app.models.service.IServicio;

@Controller
public class IndexController {
	
	//implementar el service,autowired ayuda a desacoplar el servicio de la app,
	//siempre y cuando este registrado en el contenedor de spring.
	//Qualifier: permite escoger el servio/componente en especifico a utilizar.
	@Autowired
	@Qualifier("miServicioComplejo")
	private IServicio servicio;
	
	@GetMapping({"/", "", "/index"})
	public String index(Model model) {
		model.addAttribute("objeto", servicio.operacion());
		return "index";
	}


	
	
}
