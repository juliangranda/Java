public class EjemploString {
    public static void main(String[] args) {
        String curso = "Programacion Java";
        String curso2 = new String("Programacion Java");

        //comparar el objeto/referencia de memoria.
        boolean esIgual = curso==curso2;
        System.out.println("curso==curso2 = " + esIgual);

        //comparar el valor de los strings,deben ser exactamente iguales
        // incluso con mayusculas y minusculas u otros.
        esIgual = curso.equals(curso2);
        System.out.println("curso.equals(curso2) = " + esIgual);

        //es true porque asigna/usa una referencia de tipo string existente
        //para optimizar el codigo, por lo tanto, son iguales.
        String curso3 = "Programacion Java";
        esIgual= curso==curso3;
        System.out.println("curso==curso3 = " + esIgual);

        //nota: los String se deben de usar con equals.
    }
}
