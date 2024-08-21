package org.juliangranda.pooherencia;

public class AlumnoInternacional extends Alumno{
    private String pais;
    private double notasIdiomas;

    public AlumnoInternacional(){
        System.out.println("Alumno internacional: inicilizando constructor ");
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getNotasIdiomas() {
        return notasIdiomas;
    }

    public void setNotasIdiomas(double notasIdiomas) {
        this.notasIdiomas = notasIdiomas;
    }
}
