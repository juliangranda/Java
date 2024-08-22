package org.juliangranda.pooclasesabstractas.form.validador;

public class EmailValidador extends Validador{

    protected String mensaje = "el campo %s tiene un formato de correo inválido";

    //caracter gorro = Alt+94, punto cualquier caracter, + numero de caracteres indefinidos.
    //signo de peso para que este valor tambien se encuentre al final de la linea.
    private final static String EMAIL_REGEX = "^(.+)@(.+)$";
    @Override
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public boolean esValido(String valor) {
        return valor.matches(EMAIL_REGEX);
    }
}
