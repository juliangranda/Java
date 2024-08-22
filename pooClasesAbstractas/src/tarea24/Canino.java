package tarea24;

public abstract class Canino extends Mamifero{
    protected String color;
    protected Float tamanoColmillos;

    public Canino(String habitat, float largo, float altura, float peso, String color, Float tamanoColmillos) {
        super(habitat, largo, altura, peso);
        this.color = color;
        this.tamanoColmillos = tamanoColmillos;
    }

    public String getColor() {
        return color;
    }

    public Float getTamanoColmillos() {
        return tamanoColmillos;
    }

    @Override
    public String getHabitat() {
        return habitat;
    }

    @Override
    public float getAltura() {
        return altura;
    }

    @Override
    public float getLargo() {
        return largo;
    }

    @Override
    public float getPeso() {
        return peso;
    }

    @Override
    public String getNombreCientifico() {
        return nombreCientifico;
    }
}
