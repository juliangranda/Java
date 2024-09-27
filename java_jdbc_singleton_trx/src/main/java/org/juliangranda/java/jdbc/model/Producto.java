package org.juliangranda.java.jdbc.model;

import java.util.Date;

public class Producto {
    private Long id;
    private String nombre;
    private int precio;
    private Date fechaRegistro;
    private Categoria categoria;
    private String sku;


    public Producto() {

    }

    public Producto(Long id, String nombre, int precio, Date fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.fechaRegistro = fechaRegistro;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Override
    public String toString() {
        return
                id +
                " | " +
                nombre +
                " | " +
                precio +
                " | " +
                fechaRegistro +
                " | " +
                categoria.getNombre() +
                " | " + sku;

    }
}
