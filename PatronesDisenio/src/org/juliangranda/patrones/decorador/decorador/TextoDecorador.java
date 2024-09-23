package org.juliangranda.patrones.decorador.decorador;

import org.juliangranda.patrones.decorador.Formateable;

abstract public class TextoDecorador implements Formateable {
    protected Formateable texto;

    public TextoDecorador(Formateable texto) {
        this.texto = texto;
    }
}
