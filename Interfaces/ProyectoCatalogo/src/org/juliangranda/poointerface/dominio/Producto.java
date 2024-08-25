package org.juliangranda.poointerface.dominio;

import org.juliangranda.poointerface.dominio.interfaces.IProducto;

abstract public class Producto implements IProducto {
    int precio;

    public Producto(int precio) {
        this.precio = precio;
    }

    @Override
    public int getPrecio() {
        return precio;
    }
}
