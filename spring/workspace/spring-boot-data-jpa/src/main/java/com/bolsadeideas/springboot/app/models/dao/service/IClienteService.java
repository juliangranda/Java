package com.bolsadeideas.springboot.app.models.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bolsadeideas.springboot.app.models.entity.Cliente;

import jakarta.transaction.Transactional;

/*pageable debe de ser de import org.springframework.data.domain.Page, y
 * import org.springframework.data.domain.Pageable;, no otro.
*/
public interface IClienteService {
	
	public List<Cliente> findAll();

	public Page findAll(Pageable pageable);
	
	public void save(Cliente cliente);
	
	public Cliente findOne(Long id);
	
	public void delete(Long id);
}
