package com.bolsadeideas.springboot.app.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.app.models.entity.Cliente;

//CrudRepository = predefinido en documentacion de spring data JPA
//no necesita ninguna linea de codigo por que todos los metodos
//estan de manera automatica por detras de CrudRepository,es decir,vienen
//de forma predefinida con la interfaz.
public interface IClienteDao extends CrudRepository<Cliente, Long>{
	
	
}
