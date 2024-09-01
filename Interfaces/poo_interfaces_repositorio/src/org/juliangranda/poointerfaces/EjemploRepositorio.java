package org.juliangranda.poointerfaces;

import org.juliangranda.poointerfaces.modelo.*;
import org.juliangranda.poointerfaces.repositorio.*;
import org.juliangranda.poointerfaces.repositorio.excepciones.AccesoDatoException;
import org.juliangranda.poointerfaces.repositorio.excepciones.EscrituraAccesoDatoException;
import org.juliangranda.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;
import org.juliangranda.poointerfaces.repositorio.lista.ClienteListRepositorio;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {

        try {

            OrdenablePaginableRepositorio<Cliente> repo = new ClienteListRepositorio();
            repo.crear(new Cliente("jana", "perez"));
            repo.crear(new Cliente("Bea", "Gonzalez"));
            repo.crear(new Cliente("luci", "martinez"));
            repo.crear(new Cliente("andres", "guzman"));
            repo.crear(null);

            List<Cliente> clientes = repo.listar();
            clientes.forEach(System.out::println);
            System.out.println("--------------paginable----------------");
            List<Cliente> paginable = repo.listar(1, 4);
            paginable.forEach(System.out::println);

            System.out.println("-----------ordenar -----------------");
            List<Cliente> clientesOrdenAsc = repo.listar("nombre", Direccion.DESC);

            for (Cliente c : clientesOrdenAsc) {
                System.out.println("c = " + c);
            }

            System.out.println("===== editar =====");
            Cliente beaActualizar = new Cliente("Bea", "Mena");
            beaActualizar.setId(2);
            repo.editar(beaActualizar);
            Cliente bea = repo.porId(10);
            System.out.println(bea);
            System.out.println(" ============= ");
            repo.listar("nombre", Direccion.ASC).forEach(System.out::println);
            System.out.println("===== eliminar ======");
            repo.eliminar(0);
            repo.listar().forEach(System.out::println);
            System.out.println("----------total-----------");
            System.out.println("Total registros: " + repo.total());
        }catch (LecturaAccesoDatoException e){
            System.out.println("Lectura: " + e.getMessage());
            e.printStackTrace();
            //e.printStackTrace: muestra la informacion de donde se encuentra el error.
        }catch (EscrituraAccesoDatoException e){
            System.out.println("Escritura: " + e.getMessage());
            e.printStackTrace();
        }
        catch(AccesoDatoException e){
            System.out.println("Generica: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
