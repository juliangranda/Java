package org.juliangranda.poointerfaces.imprenta.modelo;

public interface Imprimible {

    String TEXTO_DEFECTO = "imprimiendo un valor por defecto";

    //metodos default en una interface
    default String imprimir(){
        return TEXTO_DEFECTO;
    };

    //metodo static en una interface que le pertenece a la interface y no a la clase.
    static void imprimir(Imprimible imprimible){
        System.out.println(imprimible.imprimir());
    }

}
