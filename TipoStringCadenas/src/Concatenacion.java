public class Concatenacion {
    public static void main(String[] args) {
        String curso = "Programacion Java";
        String profesor = "julian gomez";

        String detalle = curso + " con el instructor " + profesor;
        System.out.println("detalle = " + detalle);

        int numeroA = 10;
        int numeroB = 5;
        System.out.println(detalle + (numeroA + numeroB));
        System.out.println(numeroA + numeroB + detalle);

        //metodo de una variable String - concat
        String detalles2 = curso.concat(" con ".concat(profesor));
        System.out.println("detalles2 = " + detalles2);
    }
}
