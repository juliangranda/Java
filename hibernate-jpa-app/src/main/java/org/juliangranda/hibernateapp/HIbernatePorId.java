package org.juliangranda.hibernateapp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.juliangranda.hibernateapp.entity.Cliente;
import org.juliangranda.hibernateapp.util.JpaUtil;

import java.util.Scanner;

public class HIbernatePorId {
    public static void main(String[] args) {

//        Scanner s = new Scanner(System.in);
//        EntityManager em = JpaUtil.getEntityManager();
//        Query query = em.createQuery("select c from Cliente c where c.id=?1", Cliente.class);
//        System.out.println("Ingrese el id: ");
//        Long pago = s.nextLong();
//        query.setParameter(1, pago);
//        Cliente c = (Cliente) query.getSingleResult();
//        System.out.println(c);
//        em.close();

        Scanner s = new Scanner(System.in);

        EntityManager em = JpaUtil.getEntityManager();
        System.out.println("Ingrese el id: ");
        Long id = s.nextLong();
        Cliente cliente = em.find(Cliente.class, id);

        System.out.println(cliente);
        em.close();
    }
}
