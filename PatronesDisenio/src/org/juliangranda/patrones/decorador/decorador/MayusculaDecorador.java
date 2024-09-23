package org.juliangranda.patrones.decorador.decorador;

import org.juliangranda.patrones.decorador.Formateable;

public class MayusculaDecorador extends TextoDecorador{
    public MayusculaDecorador(Formateable texto) {
        super(texto);
    }

    @Override
    public String darFormato() {
        return texto.darFormato().toUpperCase();
    }
}
