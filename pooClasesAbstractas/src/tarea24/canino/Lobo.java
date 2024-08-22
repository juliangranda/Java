package tarea24.canino;

import tarea24.Canino;

public class Lobo extends Canino {

    private int camada;
    private String especieLobo;

    public Lobo(String habitat, float largo, float altura, float peso, String color, Float tamanoColmillos, int camada, String especieLobo) {
        super(habitat, largo, altura, peso, color, tamanoColmillos);
        this.camada = camada;
        this.especieLobo = especieLobo;
    }

    public int getCamada() {
        return camada;
    }

    public String getEspecieLobo() {
        return especieLobo;
    }

    @Override
    public String comer() {
        return "El lobo caza en grupo en un " + habitat;
    }

    @Override
    public String dormir() {
        return "El lobo duerme en cuevas con su manada para proteger a su camada de " + camada +"lobos";
    }

    @Override
    public String correr() {
        return "El lobo corre con los de su misma especie " + especieLobo ;
    }

    @Override
    public String comunicacion() {
        return "los lobos aullan en la noche";
    }
}
