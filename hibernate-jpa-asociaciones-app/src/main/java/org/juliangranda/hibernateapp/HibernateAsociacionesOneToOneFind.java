package org.juliangranda.hibernateapp;

import jakarta.persistence.EntityManager;
import org.juliangranda.hibernateapp.entity.Cliente;
import org.juliangranda.hibernateapp.entity.ClienteDetalle;
import org.juliangranda.hibernateapp.util.JpaUtil;

public class HibernateAsociacionesOneToOneFind {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();

        try{
            em.getTransaction().begin();

            Cliente cliente = em.find(Cliente.class,2L);

            ClienteDetalle detalle = new ClienteDetalle(true, 5000L);
            em.persist(detalle);

            cliente.setDetalle(detalle);
            em.getTransaction().commit();
            System.out.println(cliente);

        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }
}
