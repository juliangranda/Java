package org.juliangranda.poointerfaces.repositorio;

public interface OrdenablePaginableRepositorio<T> extends OrdenableRepositorio<T>,
                    PaginableRepositorio<T>, CrudRepositorio<T>, ContableRepositorio{
}
