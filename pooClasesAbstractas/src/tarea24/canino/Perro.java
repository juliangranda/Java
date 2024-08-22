package tarea24.canino;

import tarea24.Canino;

public class Perro extends Canino {
    private int fuerzaMordidaM;

    public Perro(String habitat, float largo, float altura, float peso, String color, Float tamanoColmillos, int fuerzaMordidaM) {
        super(habitat, largo, altura, peso, color, tamanoColmillos);
        this.fuerzaMordidaM = fuerzaMordidaM;
    }

    public int getFuerzaMordidaM() {
        return fuerzaMordidaM;
    }

    @Override
    public String comer() {
        return "los perros hieren a su presa con mordidas de "+ fuerzaMordidaM + "psi";
    }

    @Override
    public String dormir() {
        return "los perros duerme en la noche en manada en " + habitat;
    }

    @Override
    public String correr() {
        return "los perros corren despacio para mantener su superioridad numerica";
    }

    @Override
    public String comunicacion() {
        return "los perros ladran para comunicarse entre ellos";
    }
}
