package org.juliangranda.patrones.decorador.decorador;

import org.juliangranda.patrones.decorador.Formateable;

public class SubrayadorDecorador extends TextoDecorador{
    public SubrayadorDecorador(Formateable texto) {
        super(texto);
    }

    @Override
    public String darFormato() {
        int largo = texto.darFormato().length();
        StringBuilder sb = new StringBuilder(texto.darFormato());
        sb.append("\n");
        for (int i = 0; i < largo; i++) {
            sb.append("_");
        }
        return sb.toString();
    }
}
