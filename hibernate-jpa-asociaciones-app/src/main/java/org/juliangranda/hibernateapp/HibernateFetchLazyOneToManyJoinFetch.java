package org.juliangranda.hibernateapp;

import jakarta.persistence.EntityManager;
import org.juliangranda.hibernateapp.entity.Cliente;
import org.juliangranda.hibernateapp.util.JpaUtil;

public class HibernateFetchLazyOneToManyJoinFetch {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        //consulta personalizada
        //outer join para realizar el enlace y
        //fetch para ir a buscar direcciones y se lo pasemos al objeto cliente
        //se usa para convertir dos consultas en una sola consulta sql.
        Cliente cliente = em.createQuery("select c from Cliente c left outer join fetch c.direcciones left join fetch c.detalle where c.id=:id",Cliente.class)
                .setParameter("id",1L)
                .getSingleResult();

        System.out.println(cliente.getNombre() + ", direcciones: " + cliente.getDirecciones());
        System.out.println(cliente.getNombre() + ", detalle: " + cliente.getDetalle());
        em.close();
    }
}
