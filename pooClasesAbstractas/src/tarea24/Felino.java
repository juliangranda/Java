package tarea24;

public abstract class Felino extends Mamifero{
    protected float tamanoGarras;
    protected Integer velocidad;

    public Felino(String habitat, float largo, float altura, float peso, float tamanoGarras, Integer velocidad) {
        super(habitat, largo, altura, peso);
        this.tamanoGarras = tamanoGarras;
        this.velocidad = velocidad;
    }
}
