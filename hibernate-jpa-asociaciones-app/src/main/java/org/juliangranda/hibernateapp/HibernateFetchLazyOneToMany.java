package org.juliangranda.hibernateapp;

import jakarta.persistence.EntityManager;
import org.juliangranda.hibernateapp.entity.Cliente;
import org.juliangranda.hibernateapp.util.JpaUtil;

public class HibernateFetchLazyOneToMany {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        //consultas
        Cliente cliente = em.find(Cliente.class,1L);
        System.out.println(cliente.getNombre() + ", direcciones: " + cliente.getDirecciones());
        em.close();
    }
}
