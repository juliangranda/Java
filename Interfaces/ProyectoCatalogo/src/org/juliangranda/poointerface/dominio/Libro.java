package org.juliangranda.poointerface.dominio;

import org.juliangranda.poointerface.dominio.interfaces.ILibro;

import java.util.Date;

public class Libro extends Producto implements ILibro {

    private Date fechaPublicacion;
    private String autor;
    private String titulo;
    private String editorial;

    public Libro(int precio, Date fechaPublicacion, String autor, String titulo, String editorial) {
        super(precio);
        this.fechaPublicacion = fechaPublicacion;
        this.autor = autor;
        this.titulo = titulo;
        this.editorial = editorial;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public String getEditorial() {
        return editorial;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public String getAuthor() {
        return this.autor;
    }

    @Override
    public double getPrecioVenta() {
        return this.precio;
    }
}
