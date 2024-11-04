package org.juliangranda.hibernateapp;

import jakarta.persistence.EntityManager;
import org.juliangranda.hibernateapp.dominio.ClienteDto;
import org.juliangranda.hibernateapp.entity.Cliente;
import org.juliangranda.hibernateapp.util.JpaUtil;

import javax.print.DocFlavor;
import java.util.List;

public class HibernateQL {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        System.out.println("========== consultar todos ========");
        List<Cliente> clientes = em.createQuery("select c from Cliente c", Cliente.class)
                .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("========= consulta porId =========");
        Cliente cliente = em.createQuery("select c from Cliente c where c.id=:id", Cliente.class)
                .setParameter("id", 1L)
                .getSingleResult();
        System.out.println(cliente);

        System.out.println("======== consulta solo el nombre por el id ========");
        String nombreCliente = em.createQuery("select c.nombre from Cliente c where c.id=:id", String.class)
                .setParameter("id",2L)
                .getSingleResult();
        System.out.println(nombreCliente);

        System.out.println("=========consultas por campos personalizados==========");
        Object[] objectoCliente = em.createQuery("select c.id, c.nombre, c.apellido from Cliente c where c.id=:id", Object[].class)
                .setParameter("id",1L)
                .getSingleResult();
        Long id = (Long) objectoCliente[0];
        String nombre = (String) objectoCliente[1];
        String apellido = (String) objectoCliente[2];
        System.out.println("id=" + id + ",nombre="+ nombre + ",apellido=" + apellido);

        System.out.println("=========consultas por campos personalizados lista==========");
        //solo para arreglos -> permite mostrar varios datos al mismo tiempo.
        List<Object[]> registros = em.createQuery("select c.id, c.nombre, c.apellido from Cliente c", Object[].class)
                .getResultList();
        //for (Object[] reg: registros){
        registros.forEach( reg -> {
            Long idCli = (Long) reg[0];
            String nombreCli = (String) reg[1];
            String apellidoCli = (String) reg[2];
            System.out.println("id=" + idCli + ",nombre="+ nombreCli + ",apellido=" + apellidoCli);
        });
        //}

        System.out.println("========== consulta por cliente y forma de pago");
        registros  = em.createQuery("select c, c.formaPago from Cliente c", Object[].class)
                        .getResultList();
        registros.forEach(reg -> {
            Cliente c = (Cliente) reg[0];
            String formaPago = (String) reg[1];
            System.out.println("formaPago=" + formaPago + "," + c);
        });

        System.out.println("=========== consulta que puebla y envuelve objeto entity de una clase personalizada =====");
        clientes = em.createQuery("select new Cliente(c.nombre, c.apellido) from Cliente c", Cliente.class)
                        .getResultList();
        clientes.forEach(System.out::println);

        //añade el url del package ClienteDto para que reconozca la clase.
        System.out.println("=========== consulta que puebla y envuelve objeto otro de una clase personalizada =====");
        List<ClienteDto> clientesDto = em.createQuery("select new org.juliangranda.hibernateapp.dominio.ClienteDto(c.nombre, c.apellido) from Cliente c", ClienteDto.class)
                .getResultList();
        clientesDto.forEach(System.out::println);

        System.out.println("====== consulta con nombre de cliente ======");
        List<String> nombres = em.createQuery("select c.nombre from Cliente c", String.class)
                        .getResultList();
        nombres.forEach(System.out::println);

        //solo nombres unicos sin duplicados
        System.out.println("========= consulta con nombres unicos de clientes ====");
        nombres = em.createQuery("select distinct(c.nombre) from Cliente c", String.class)
                        .getResultList();
        nombres.forEach(System.out::println);

        System.out.println("========= consulta con formas de pago unicas");
        List<String> formaPago = em.createQuery("select distinct(c.formaPago) from Cliente c", String.class)
                        .getResultList();
        formaPago.forEach(System.out::println);

        System.out.println("========= consulta con numero de formas de pago unicas");
        Long totalFormasPago = em.createQuery("select count(distinct(c.formaPago)) from Cliente c", Long.class)
                        .getSingleResult();
        System.out.println(totalFormasPago);

        System.out.println("====== consulta con nombre y apellido concatenados ====");
//        nombres = em.createQuery("select concat(c.nombre, ' ', c.apellido) as nombreCompleto from Cliente c", String.class)
//                        .getResultList();
//        nombres.forEach(System.out::println);

        nombres = em.createQuery("select c.nombre || ' ' || c.apellido as nombreCompleto from Cliente c", String.class)
                .getResultList();
        nombres.forEach(System.out::println);

        System.out.println("====== consulta con nombre y apellido en mayuscula ====");
        nombres = em.createQuery("select upper(concat(c.nombre, ' ', c.apellido)) as nombreCompleto from Cliente c", String.class)
                        .getResultList();
        nombres.forEach(System.out::println);

        System.out.println("====== consulta con nombre y apellido en minuscula ====");
        nombres = em.createQuery("select lower(concat(c.nombre, ' ', c.apellido)) as nombreCompleto from Cliente c", String.class)
                .getResultList();
        nombres.forEach(System.out::println);

        System.out.println("========= consulta para buscar por nombre ==========");
        String param = "NA";
        //es buena practica que se busque los datos en mayuscula
        clientes = em.createQuery("select c from Cliente c where upper(c.nombre) like upper(:parametro)", Cliente.class)
                //al usar el "%" busca las letras a la derecha y/o izquierda
                .setParameter("parametro", "%" + param + "%")
                        .getResultList();
        clientes.forEach(System.out::println);
        em.close();
    }
}
