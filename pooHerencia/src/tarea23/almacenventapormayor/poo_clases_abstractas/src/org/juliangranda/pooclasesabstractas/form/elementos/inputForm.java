package org.juliangranda.pooclasesabstractas.form.elementos;

public class inputForm extends ElementoForm{

    private String tipo = "text";

    public inputForm(String nombre) {
        super(nombre);
    }

    public inputForm(String nombre, String tipo) {
        super(nombre);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String dibujarHtml() {
        return "<input type=\"" + this.tipo
                + "\" name=\"" + this.nombre
                + "\" value=\"" + this.valor + "\">";
    }
}
