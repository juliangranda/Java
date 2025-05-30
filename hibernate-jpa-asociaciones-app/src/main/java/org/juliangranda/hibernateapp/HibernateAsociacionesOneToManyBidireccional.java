package org.juliangranda.hibernateapp;

import jakarta.persistence.EntityManager;
import org.juliangranda.hibernateapp.entity.Cliente;
import org.juliangranda.hibernateapp.entity.Factura;
import org.juliangranda.hibernateapp.util.JpaUtil;

public class HibernateAsociacionesOneToManyBidireccional {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        try{

            em.getTransaction().begin();

            Cliente cliente = new Cliente("Cata","Edu");
            cliente.setFormaPago("paypal");

            Factura f1 = new Factura("compras de supermercado", 5000L);
            Factura f2 = new Factura("compras de tecnologia", 7000L);

            cliente.addFactura(f1)
                    .addFactura(f2);

            em.persist(cliente);
            em.getTransaction().commit();
            System.out.println(cliente);
            em.getTransaction().begin();

            //Factura f3 = em.find(Factura.class,1L); //alternativa
            Factura f3 = new Factura("compras de supermercado", 5000L);
            f3.setId(1L);
            //eliminar factura en ambos lados
            cliente.removeFactura(f3);
            em.getTransaction().commit();
            System.out.println(cliente);
        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally{
            em.close();
        }
    }
}
