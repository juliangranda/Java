package org.juliangranda.poointerfaces.repositorio;

import org.juliangranda.poointerfaces.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio {

    List<Cliente> listar(String campo, Direccion dir);

}
