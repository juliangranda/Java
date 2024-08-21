package org.juliangranda.pooherencia;

public class Alumno extends Persona{
    private String institucion;
    private double notaMatematica;
    private double notaCastellana;
    private double notaHistoria;

    public Alumno(){
        System.out.println("Alumno: Inicilizando constructor ");
    }

    public Alumno(String nombre, String apellido){
        super(nombre,apellido);
    }

    public Alumno(String nombre,String apellido,int edad){
        super(nombre, apellido, edad);
    }

    public Alumno(String nombre,String apellido,int edad,String institucion){
        super(nombre, apellido, edad);
        this.institucion = institucion;
    }

    public Alumno(String nombre,String apellido,int edad,String institucion,
                  double notaMatematica,double notaCastellana,double notaHistoria){
        this(nombre, apellido, edad,institucion);
        this.notaMatematica = notaMatematica;
        this.notaCastellana = notaCastellana;
        this.notaHistoria = notaHistoria;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public double getNotaMatematica() {
        return notaMatematica;
    }

    public void setNotaMatematica(double notaMatematica) {
        this.notaMatematica = notaMatematica;
    }

    public double getNotaCastellana() {
        return notaCastellana;
    }

    public void setNotaCastellana(double notaCastellana) {
        this.notaCastellana = notaCastellana;
    }

    public double getNotaHistoria() {
        return notaHistoria;
    }

    public void setNotaHistoria(double notaHistoria) {
        this.notaHistoria = notaHistoria;
    }

    @Override
    public String saludar(){
        String saludar = super.saludar();
        return saludar + " soy un alumnno mi nombre es "+getNombre();
    }

    public double calcularPromedio(){
        System.out.println("calcular promedio " + this.getClass().getCanonicalName());
        return (notaHistoria + notaCastellana + notaMatematica)/3;
    }
}
