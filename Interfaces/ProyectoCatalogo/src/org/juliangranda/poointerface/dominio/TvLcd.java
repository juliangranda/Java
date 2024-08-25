package org.juliangranda.poointerface.dominio;

import org.juliangranda.poointerface.dominio.interfaces.IProducto;

public class TvLcd extends Electronico {

    private int pulgada;

    public TvLcd(int precio, String fabricante, int pulgada) {
        super(precio, fabricante);
        this.pulgada = pulgada;
    }

    public int getPulgada() {
        return pulgada;
    }

    @Override
    public int getPrecio() {
        return this.precio;
    }

    @Override
    public double getPrecioVenta() {
        return this.precio;
    }
}
