public enum Color {

    //colleciones de valores/atributos CONSTANTES

    ROJO("Rojo"),
    AMARILLO("Amarillo"),
    AZUL("Azul"),
    BLANCO("Blanco"),
    GRIS("Gris Oscuro"),
    NARANJA("Naranja");

    //el punto y coma ( ; ) solo es necesario cuando vamos a crear un constructor
    //de lo contrario no va este.
    //ademas se pondria al lado de la constante en mayusculas ->
    //la palabra o string que se quisiera mostrar pero sino va el punto y coma no es necesario.

    private final String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return this.color;
    }
}
