public class Inmutable {
    public static void main(String[] args) {

        //los String son inmutables, es decir, no cambian.
        String curso = "Programacion Java";
        String profesor = "julian gomez";

        String resultado = curso.concat(profesor);
        System.out.println("profesor = " + curso);
        System.out.println("resultado = " + resultado);
        System.out.println(curso == resultado);

        //concatencion pero con funcion lambda.
        String resultado2 = curso.transform(c -> {
           return c + " con " + profesor;
        });
        System.out.println("curso = " + curso);
        System.out.println(resultado2);

        //reemplazar un caracter por otro.
        String resultado3 = resultado.replace("a","A");
        System.out.println("resultado = " + resultado);
        System.out.println("resultado3 = " + resultado3);
    }
}
