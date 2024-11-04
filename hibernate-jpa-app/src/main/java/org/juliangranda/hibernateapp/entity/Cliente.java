package org.juliangranda.hibernateapp.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

//el siguiente codigo esta relacionado con la informacion de la BD.
@Entity
@Table(name="clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;

    @Column(name="forma_pago")
    private String formaPago;

    @Column(name="creado_en")
    private LocalDateTime creadoEn;
    @Column(name="editado_en")
    private LocalDateTime editadoEn;
    public Cliente() {
        //obligatorio:
        //si se genera un constructor con parametros debe de haber un constructor vacio.
    }

    public Cliente(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Cliente(Long id, String nombre, String apellido, String formaPago) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.formaPago = formaPago;
    }

    @PrePersist
    public void prePersist(){
        System.out.println("inicializar algo justo antes del persist");
        this.creadoEn = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        System.out.println("inicializar algo justo antes del update");
        this.editadoEn = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }

    public LocalDateTime getEditadoEn() {
        return editadoEn;
    }

    public void setEditadoEn(LocalDateTime editadoEn) {
        this.editadoEn = editadoEn;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", formaPago='" + formaPago + '\'' +
                ", creadoEn='" + creadoEn + '\'' +
                ", editadoEn='" + editadoEn + '\'';
    }
}
