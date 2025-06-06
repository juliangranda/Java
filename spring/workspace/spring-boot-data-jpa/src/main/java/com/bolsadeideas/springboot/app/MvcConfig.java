package com.bolsadeideas.springboot.app;

import java.nio.file.Paths;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	private final Logger log = org.slf4j.LoggerFactory.getLogger(getClass());
	
	/*@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addResourceHandlers(registry);
		
		String resourcePath = Paths.get("uploads").toAbsolutePath().toUri().toString();
		log.info(resourcePath);
		//registrar otro directorio en este caso: temp/uploads  como recurso 
		//estatico de nuestra aplicacion.
		registry.addResourceHandler("/uploads/** ")
		.addResourceLocations("file:/C:/Temp/uploads/");
	}*/
	
}
