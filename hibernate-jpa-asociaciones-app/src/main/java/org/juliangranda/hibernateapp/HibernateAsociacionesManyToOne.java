package org.juliangranda.hibernateapp;

import jakarta.persistence.EntityManager;
import org.juliangranda.hibernateapp.entity.Cliente;
import org.juliangranda.hibernateapp.entity.Factura;
import org.juliangranda.hibernateapp.util.JpaUtil;

public class HibernateAsociacionesManyToOne {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();

        try{
            em.getTransaction().begin();
            Cliente cliente = new Cliente("Cata", "Edu");
            cliente.setFormaPago("credito");
            em.persist(cliente);

            Factura factura = new Factura("Compras de oficina", 1000L);
            factura.setCliente(cliente);
            em.persist(factura);

            System.out.println(factura.getCliente());
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
    }
}
