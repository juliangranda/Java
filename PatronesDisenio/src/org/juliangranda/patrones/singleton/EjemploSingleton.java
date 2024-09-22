package org.juliangranda.patrones.singleton;

public class EjemploSingleton {
    public static void main(String[] args) {
        //Patron de diseño de tipo creacional.
//        nos permite crear una solo instancia de una clase,solo una,
//        armamos nuestro diseño,nuestra clase,de tal forma que nos permita
//        siempre crear una sola referencia,una instancia compartida
//        para toda la aplicacion, tipicamente se usa en bases de datos.
        ConexionBDSingleton con = null;
        for (int i = 0; i<10;i++){
             con = ConexionBDSingleton.getInstancia();
            System.out.println("con = " + con);
        }
        ConexionBDSingleton con2 = ConexionBDSingleton.getInstancia();
        ConexionBDSingleton con3 = ConexionBDSingleton.getInstancia();
        boolean b1 = (con == con2) && (con2 == con3) && (con == con3);
        System.out.println("b1 = " + b1);

    }
}
