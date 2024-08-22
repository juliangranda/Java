package tarea24.felino;

import tarea24.Felino;

public class Guepardo extends Felino {

    public Guepardo(String habitat, float largo, float altura, float peso, float tamanoGarras, Integer velocidad) {
        super(habitat, largo, altura, peso, tamanoGarras, velocidad);
    }

    @Override
    public String comer() {
        return "el guepardo caza en solitario en las "+ habitat +"  a altas temperaturas";
    }

    @Override
    public String dormir() {
        return "el guepardo duerme en solitario en lo alto de un arbol";
    }

    @Override
    public String correr() {
        return "el guepardo corre a una velocidad de "+ velocidad +"km/h";
    }

    @Override
    public String comunicacion() {
        return "";
    }
}
