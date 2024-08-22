package tarea24.felino;

import tarea24.Felino;

public class Tigre extends Felino {
    private String especieTigre;

    public Tigre(String habitat, float largo, float altura, float peso, float tamanoGarras, Integer velocidad, String especieTigre) {
        super(habitat, largo, altura, peso, tamanoGarras, velocidad);
        this.especieTigre = especieTigre;
    }

    public String getEspecieTigre() {
        return especieTigre;
    }

    @Override
    public String comer() {
        return "El tigre caza en los " + habitat + " usando unas garras de " + tamanoGarras + "cm"+" para matar a su presa";
    }

    @Override
    public String dormir() {
        return "Duerme en solitario en los " + habitat;
    }

    @Override
    public String correr() {
        return "El tigre corre a una velocidad de "+ velocidad + "por los " + habitat;
    }

    @Override
    public String comunicacion() {
        return "El tigre ruge para intimidar a otro de su especie";
    }
}
