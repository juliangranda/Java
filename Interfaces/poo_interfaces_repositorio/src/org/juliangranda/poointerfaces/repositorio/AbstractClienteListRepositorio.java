package org.juliangranda.poointerfaces.repositorio;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractClienteListRepositorio<T> implements OrdenablePaginableRepositorio<T>{

    protected List<T> dataSource;

    public AbstractClienteListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return dataSource;
    }

    /*@Override
    public Cliente porID(Integer id) {
        Cliente resultado = null;
        for(Cliente cli: dataSource){
            if(cli.getId() != null && cli.getId().equals(id)){
                resultado = cli;
                break;
            }
        }
        return resultado;
    }
*/
    @Override
    public void crear(T t) {
        this.dataSource.add(t);
    }

    @Override
    public void eliminar(Integer id) {
        this.dataSource.remove(this.porID(id));
    }

    @Override
    public List<T> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }

    @Override
    public int total() {
        return this.dataSource.size();
    }
}
