package org.juliangranda.poointerfaces;

import org.juliangranda.poointerfaces.modelo.*;
import org.juliangranda.poointerfaces.repositorio.*;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {

        OrdenablePaginableRepositorio repo = new ClienteListRepositorio();
        repo.crear(new Cliente("jana","perez"));
        repo.crear(new Cliente("Bea","Gonzalez"));
        repo.crear(new Cliente("luci","martinez"));
        repo.crear(new Cliente("andres","guzman"));

        List<Cliente> clientes = repo.listar();
        clientes.forEach(System.out::println);
        System.out.println("--------------paginable----------------");
        List<Cliente> paginable = repo.listar(1,4);
        paginable.forEach(System.out::println);

        System.out.println("-----------ordenar -----------------");
        List<Cliente> clientesOrdenAsc = repo.listar("nombre",Direccion.DESC);

        for (Cliente c:clientesOrdenAsc){
            System.out.println("c = " + c);
        }

        System.out.println("===== editar =====");
        Cliente beaActualizar = new Cliente("Bea", "Mena");
        beaActualizar.setId(2);
        repo.editar(beaActualizar);
        Cliente bea = repo.porID(2);
        System.out.println(bea);
        System.out.println(" ============= ");
        repo.listar("nombre", Direccion.ASC).forEach(System.out::println);
        System.out.println("===== eliminar ======");
        repo.eliminar(2);
        repo.listar().forEach(System.out::println);
        System.out.println("----------total-----------");
        System.out.println("Total registros: " + repo.total());
    }
}