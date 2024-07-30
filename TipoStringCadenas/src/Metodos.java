public class Metodos {
    public static void main(String[] args) {

        String nombre = "julian";

        System.out.println("nombre.length() = " + nombre.length());
        System.out.println("nombre.toUpperCase() = " + nombre.toUpperCase());
        System.out.println("nombre.toLowerCase() = " + nombre.toLowerCase());
        System.out.println("nombre.equals(\"Julian\") = " + nombre.equals("Julian"));
        System.out.println("nombre.equals(\"julian\") = " + nombre.equals("julian"));
        //ignora la mayuscula y minuscula.
        System.out.println("nombre.equalsIgnoreCase(\"julian\") = " + nombre.equalsIgnoreCase("julian"));
        //Comparacion basado de orden numerico en unicode/lexicografico
        System.out.println("nombre.compareTo(\"Julian\") = " + nombre.compareTo("Julian"));
        System.out.println("nombre.compareTo(\"Aaron\") = " + nombre.compareTo("Aaron"));
        //imprime el caracter en el indice especificado
        System.out.println("nombre.charAt(0) = " + nombre.charAt(0));
        System.out.println("nombre.charAt(1) = " + nombre.charAt(1));
        //imprime la ultima posicion del string
        System.out.println("nombre.charAt(nombre.length()-1) = " + nombre.charAt(nombre.length()-1));

        //muestra despues de la posicion del indice dado
        System.out.println("nombre.substring(1) = " + nombre.substring(1));
        System.out.println("nombre.substring(1, 4) = " + nombre.substring(1, 4));
        System.out.println("nombre.substring(nombre.length()-2) = " + nombre.substring(nombre.length()-2));

    }
}
