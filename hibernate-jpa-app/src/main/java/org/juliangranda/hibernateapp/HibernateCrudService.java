package org.juliangranda.hibernateapp;

import jakarta.persistence.EntityManager;
import org.juliangranda.hibernateapp.entity.Cliente;
import org.juliangranda.hibernateapp.services.ClienteService;
import org.juliangranda.hibernateapp.services.ClienteServiceImpl;
import org.juliangranda.hibernateapp.util.JpaUtil;

import java.util.List;
import java.util.Optional;

public class HibernateCrudService {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();

        ClienteService service = new ClienteServiceImpl(em);

        System.out.println("======== Listar =======");
        List<Cliente> clientes = service.listar();
        clientes.forEach(System.out::println);

        System.out.println("========obtener por id===========");
        Optional<Cliente> optionalCliente = service.porId(1L);
        optionalCliente.ifPresent(System.out::println);

        System.out.println("========= Insertar nuevo cliente =======");
        Cliente cliente = new Cliente();
        cliente.setNombre("Luci");
        cliente.setApellido("Mena");
        cliente.setFormaPago("paypal");

        service.guardar(cliente);
        System.out.println("Cliente guardado con exito");
        service.listar().forEach(System.out::println);

        System.out.println("======== Editar Cliente =======");
        Long id = cliente.getId();
        optionalCliente = service.porId(id);
        optionalCliente.ifPresent(c -> {
            c.setFormaPago("mercado pago");
            service.guardar(c);
            System.out.println("Cliente Editado con exito");
            service.listar().forEach(System.out::println);
        });

        System.out.println("======= Eliminar Cliente ===========");
        id = cliente.getId();
        optionalCliente = service.porId(id);
        optionalCliente.ifPresent(c -> {
            service.eliminar(c.getId());
            System.out.println("Cliente Eliminado con exito");
            service.listar().forEach(System.out::println);
        });

//        if(optionalCliente.isPresent()){
//            service.eliminar(id);
//        }

        em.close();
    }
}
