package org.juliangranda.poointerfaces.repositorio;

import org.juliangranda.poointerfaces.modelo.BaseEntity;
import org.juliangranda.poointerfaces.modelo.Producto;
import org.juliangranda.poointerfaces.repositorio.excepciones.*;

import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;
import java.util.List;

public abstract class AbstractListRepositorio<T extends BaseEntity> implements OrdenablePaginableRepositorio<T>{

    protected List<T> dataSource;

    public AbstractListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return dataSource;
    }

    @Override
    public T porId(Integer id) throws LecturaAccesoDatoException{
        if(id == null || id <= 0){
            throw new LecturaAccesoDatoException("id invalido debe de ser > 0");
        }
        T resultado = null;
        for(T cli: dataSource){
            if(cli.getId() != null && cli.getId().equals(id)){
                resultado = cli;
                break;
            }
        }
        if(resultado == null){
            throw  new LecturaAccesoDatoException("No existe el id: " + id);
        }
        return resultado;
    }

    @Override
    public void crear(T t) throws EscrituraAccesoDatoException {
        if(t == null){
            throw new EscrituraAccesoDatoException("Error al insertar un objeto null");
        }
        if(this.dataSource.contains(t)){
            throw new DuplicateFormatFlagsException("Error el objeto con id "
                    + t.getId() + " existe en el repositorio");
        }
        this.dataSource.add(t);
    }

    @Override
    public void eliminar(Integer id) throws LecturaAccesoDatoException{
        this.dataSource.remove(this.porId(id));
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
