package com.bolsadeideas.springboot.error.app.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bolsadeideas.springboot.error.app.domain.Usuario;
import com.bolsadeideas.springboot.error.app.domain.services.UsuarioService;
import com.bolsadeideas.springboot.error.app.errors.UsuarioNoEncontradoException;


/*
 * utilizado para el manejo de exceptions(errores) 
 * y se manejan en un metodo usando @ControllerAdvice que 
 * se mapea a una excepcion.puede capturar 1 o + exceptions.
*/

@ControllerAdvice
public class ErrorHandlerController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@ExceptionHandler(ArithmeticException.class)
	public String aritmeticaError(ArithmeticException ex,Model model) {
		model.addAttribute("error","error de aritmetica");
		model.addAttribute("message",ex.getMessage());
		model.addAttribute("status",HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/generica";
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public String numberFormatoError(NumberFormatException ex, Model model) {
		model.addAttribute("error","Formato numero invalido!");
		model.addAttribute("message",ex.getMessage());
		model.addAttribute("status",HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return"error/numero-formato";
	}
	
	@ExceptionHandler(UsuarioNoEncontradoException.class)
	public String usuarioEncontrado(UsuarioNoEncontradoException ex, Model model) {
		model.addAttribute("error","usuario no encontrado");
		model.addAttribute("message",ex.getMessage());
		model.addAttribute("status",HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return"error/usuario";
	}
	
}
