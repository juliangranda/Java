package tarea24.felino;

import tarea24.Felino;

public class Leon extends Felino {

    private int tipoManada;
    private float potenciaRugido;

    public Leon(String habitat, float largo, float altura, float peso, float tamanoGarras, Integer velocidad, int tipoManada, float potenciaRugido) {
        super(habitat, largo, altura, peso, tamanoGarras, velocidad);
        this.tipoManada = tipoManada;
        this.potenciaRugido = potenciaRugido;
    }

    public int getTipoManada() {
        return tipoManada;
    }

    public float getPotenciaRugido() {
        return potenciaRugido;
    }

    @Override
    public String comer() {
        return "El León caza junto a su grupo de " + tipoManada + " individuos en  " + habitat;
    }

    @Override
    public String dormir() {
        return "El leon duerme al aire libre en "+habitat;
    }

    @Override
    public String correr() {
        return "El leon corre a una velocidad de "+ velocidad;
    }

    @Override
    public String comunicacion() {
        return "El leon "+ "ruge con una potencia de " + potenciaRugido;
    }
}
