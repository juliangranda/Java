package org.juliangranda.hibernateapp;

import jakarta.persistence.EntityManager;
import org.juliangranda.hibernateapp.entity.Cliente;
import org.juliangranda.hibernateapp.entity.Direccion;
import org.juliangranda.hibernateapp.util.JpaUtil;

public class HibernateAsociacionesOneToManyFind {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        try{
            em.getTransaction().begin();

            Cliente cliente = em.find(Cliente.class, 2L);
            cliente.setFormaPago("mercado pago");

            Direccion d1 = new Direccion("el vergel",123);
            Direccion d2 = new Direccion("vasco de gama",456);

            cliente.getDirecciones().add(d1);
            cliente.getDirecciones().add(d2);
            //merge es para actualizar/update
            em.merge(cliente);

            em.getTransaction().commit();

            System.out.println(cliente);
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
    }
}
