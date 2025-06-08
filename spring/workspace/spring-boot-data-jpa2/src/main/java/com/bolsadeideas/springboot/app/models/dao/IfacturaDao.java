package com.bolsadeideas.springboot.app.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.app.models.entity.Factura;

public interface IfacturaDao extends CrudRepository<Factura, Long>{
	//FORMA RECOMENDADA POR SER MEJOR.
	//join fetch sin necesidad de realizarla de forma perezosa con Lazy.
	//para hacer todas las relaciones sql de una sola vez con join fetch.
	
	//opinio:realizar las consultas en sql del workbench o postman para mayor seguridad y facilidad.
	
	@Query("select f from Factura f join fetch f.cliente c join fetch f.items l join fetch l.producto where f.id=?1")
	public Factura fetchByIdWithClienteWithItemFacturaWithProducto(Long id);
		
}
