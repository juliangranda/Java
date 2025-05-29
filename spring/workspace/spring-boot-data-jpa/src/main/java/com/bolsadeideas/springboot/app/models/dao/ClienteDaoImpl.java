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
 * @Transactional = gestiona transacciones de bases de datos 
 * de forma declarativa, asegurando que las operaciones dentro 
 * de un método se confirmen o reviertan completamente según su éxito o fracaso.
 * */
@Repository()
public class ClienteDaoImpl implements IClienteDao {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("uncheked")
	@Override
	public List<Cliente> findAll() {
		return em.createQuery("from Cliente").getResultList();
	}

	@Override
	public Cliente findOne(Long id) {
		return em.find(Cliente.class, id);
	}
	
	@Override
	public void save(Cliente cliente) {
		if(cliente.getId() != null && cliente.getId() > 0) {
			em.merge(cliente);
		}else {
			em.persist(cliente);
		}			
	}

	@Override
	public void delete(Long id) {
		//Cliente cliente = findOne(id);
		//em.remove(cliente);
		em.remove(findOne(id));
	}

}
