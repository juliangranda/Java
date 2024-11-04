package org.juliangranda.hibernateapp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Parameter;
import jakarta.persistence.criteria.*;
import org.juliangranda.hibernateapp.entity.Cliente;
import org.juliangranda.hibernateapp.util.JpaUtil;

import java.util.Arrays;
import java.util.List;

public class HibernateCriteria {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();

        CriteriaBuilder criteria = em.getCriteriaBuilder();
        CriteriaQuery<Cliente> query = criteria.createQuery(Cliente.class);

        Root<Cliente> from = query.from(Cliente.class);

        query.select(from);
        List<Cliente> clientes = em.createQuery(query).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("========== listar where equals ==========");

        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        ParameterExpression<String> nombreParam = criteria.parameter(String.class, "nombre");

        query.select(from).where(criteria.equal(from.get("nombre"), nombreParam));
        clientes = em.createQuery(query).setParameter("nombre", "Andres").getResultList();
        clientes.forEach(System.out::println);

        System.out.println("========== usando where like para buscar clientes por nombre ==========");

        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        ParameterExpression<String> nombreParamLike = criteria.parameter(String.class, "nombreParam");
        query.select(from).where(criteria.like(criteria.upper(from.get("nombre")), criteria.upper(nombreParamLike)));
        clientes = em.createQuery(query).setParameter("nombreParam", "%jo%")
                .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("=========== ejemplo usando where between para rangos ======");
        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        query.select(from).where(criteria.between(from.get("id"),2L,6L));
        clientes = em.createQuery(query).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("========== consulta where in ========");
        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        ParameterExpression<List> listaParam = criteria.parameter(List.class, "nombres");
        query.select(from).where(from.get("nombre").in(listaParam));
        clientes = em.createQuery(query)
                .setParameter("nombres", Arrays.asList("andres", "Jhon", "Lou"))
                .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("======== filtrar usando predicados mayor que o mayor igual que");
        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        //le = menor(>) o igual a el numero del id / lt menor que (<=)
        query.select(from).where(criteria.gt(from.get("id"), 2L));
        clientes = em.createQuery(query).getResultList();
        clientes.forEach(System.out::println);

        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        //ge = mayor que o igual(>=)a el numero del id / gt = mayor que(>)
        query.select(from).where(criteria.ge(criteria.length(from.get("nombre")), 5L));
        clientes = em.createQuery(query).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("====== consulta con los predicados conjuncion and y disyuncion or =======");
        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        Predicate porNombre = criteria.equal(from.get("nombre"),"Andres");
        Predicate porFormaPago = criteria.equal(from.get("formaPago"),"debito");
        Predicate p3 = criteria.ge(from.get("id"),4L);
        //query.select(from).where(criteria.or(porNombre, porFormaPago));
        query.select(from).where(criteria.and(p3, criteria.or(porNombre, porFormaPago)));
        clientes = em.createQuery(query).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("========== consultas con order by asc desc =========");

        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);

        query.select(from).orderBy(criteria.desc(from.get("nombre")), criteria.asc(from.get("apellido")));
        clientes = em.createQuery(query).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("========== consulta por id ===========");
        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        ParameterExpression<Long> idParam = criteria.parameter(Long.class, "id");

        query.select(from).where(criteria.equal(from.get("id"), idParam));

        Cliente cliente = em.createQuery(query)
                .setParameter("id", 1L)
                .getSingleResult();
        System.out.println(cliente);

        System.out.println("========== consulta solo el nombre de los clientes ==========");
        CriteriaQuery<String> queryString = criteria.createQuery(String.class);
        from = queryString.from(Cliente.class);
        queryString.select(from.get("nombre"));
        List<String> nombres = em.createQuery(queryString).getResultList();
        nombres.forEach(System.out::println);


        System.out.println("========== consulta solo el nombre de los clientes unicos con distinct ==========");
        queryString = criteria.createQuery(String.class);
        from = queryString.from(Cliente.class);
        queryString.select(criteria.upper(from.get("nombre"))).distinct(true);
        nombres = em.createQuery(queryString).getResultList();
        nombres.forEach(System.out::println);

        System.out.println("=========== consulta por nombres y apellidos concatenados ==========");
        queryString = criteria.createQuery(String.class);
        from = queryString.from(Cliente.class);

        queryString.select(criteria.concat(criteria.concat(from.get("nombre"), " "), from.get("apellido")));
        nombres = em.createQuery(queryString).getResultList();
        nombres.forEach(System.out::println);

        System.out.println("=========== consulta por nombres y apellidos concatenados upper o lower ==========");
        queryString = criteria.createQuery(String.class);
        from = queryString.from(Cliente.class);

        queryString.select(criteria.upper(criteria.concat(criteria.concat(from.get("nombre"), " "), from.get("apellido"))));
        nombres = em.createQuery(queryString).getResultList();
        nombres.forEach(System.out::println);
        em.close();

    }
}
