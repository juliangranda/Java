package com.bolsadeideas.springboot.app.models.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.bolsadeideas.springboot.app.models.entity.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

/*@Repository
 * es una anotacion de spring para marcar la clase como  
 * componente de persistencia de acceso de datos(DAO). 
 * 
 * EntityManager: se encarga de manejar las clases entidades.
 * el ciclo de vida las persiste dentro del contexto,
 * las actualiza,las elimina,puede realizar consultas.
 * las consultas son de JPA.CRUD
 * */
@Repository()
public class ClienteDaoImpl implements IClienteDao {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("uncheked")
	@Transactional
	@Override
	public List<Cliente> findAll() {
		
		return em.createQuery("from Cliente").getResultList();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		em.persist(cliente);		
	}

}
