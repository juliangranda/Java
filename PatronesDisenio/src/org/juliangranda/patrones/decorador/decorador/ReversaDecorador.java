package org.juliangranda.patrones.decorador.decorador;

import org.juliangranda.patrones.decorador.Formateable;

public class ReversaDecorador extends TextoDecorador {
    public ReversaDecorador(Formateable texto) {
        super(texto);
    }

    @Override
    public String darFormato() {
        StringBuilder sb = new StringBuilder(texto.darFormato());
        return sb.reverse().toString();
    }
}
