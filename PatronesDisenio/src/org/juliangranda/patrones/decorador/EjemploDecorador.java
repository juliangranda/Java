package org.juliangranda.patrones.decorador;

import org.juliangranda.patrones.decorador.decorador.MayusculaDecorador;
import org.juliangranda.patrones.decorador.decorador.ReemplazarEspacioDecorador;
import org.juliangranda.patrones.decorador.decorador.ReversaDecorador;
import org.juliangranda.patrones.decorador.decorador.SubrayadorDecorador;

public class EjemploDecorador {
    public static void main(String[] args) {
        Formateable texto = new Texto("Hola que tal andres");

        MayusculaDecorador mayuscula = new MayusculaDecorador(texto);
        ReversaDecorador reversa = new ReversaDecorador(mayuscula);
        SubrayadorDecorador subrayar = new SubrayadorDecorador(reversa);
        ReemplazarEspacioDecorador reemplazar = new ReemplazarEspacioDecorador(subrayar);

        System.out.println(reemplazar.darFormato());
    }
}
