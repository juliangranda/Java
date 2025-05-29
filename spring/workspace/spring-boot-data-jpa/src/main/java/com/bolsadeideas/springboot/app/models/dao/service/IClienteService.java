package com.bolsadeideas.springboot.app.models.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bolsadeideas.springboot.app.models.entity.Cliente;

import jakarta.transaction.Transactional;

public interface IClienteService {
	
	@Autowired
	@Transactional
	public List<Cliente> findAll();

	@Autowired
	@Transactional
	public void save(Cliente cliente);
	
	@Transactional
	public Cliente findOne(Long id);
	
	@Transactional
	public void delete(Long id);
}
