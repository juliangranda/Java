package com.bolsadeideas.springboot.di.app.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component("miServicioComplejo")
public class MiServicioComplejo implements IServicio{
	
	@Override
	public String operacion() {
		return "ejecutar algun proceso importante complicado";
	}
}
