package org.juliangranda.poointerfaces.repositorio.excepciones;

public class RegistroDuplicadoAccesoDatoException extends EscrituraAccesoDatoException{
    public RegistroDuplicadoAccesoDatoException(String message) {
        super(message);
    }
}
