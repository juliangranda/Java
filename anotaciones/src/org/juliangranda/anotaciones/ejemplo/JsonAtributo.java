package org.juliangranda.anotaciones.ejemplo;

//las anotaciones siempre se utilizan con una @

import java.lang.annotation.*;

//Anotacion = es una estructura muy parecida a una interfaz,ya que nos permite
//agregar metada o configuracion a nuestras clases ya sea la clase,atributo,metodos,
//basicamente representa la configuracion parecido a los .xml.
//pero mas utilizado y orientada a POO.
//target = donde se va aplicar la anotacion metodo,atributo,constructor, donde?
//TYPE es sobre una clase , FIELD sobre un atributo.
//segundo en que contexto se va a ejecutar la anotacion
// =Runtime(tiempo ejecucion) o Class(tiempo de compilacion)

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonAtributo {
    //atributos de la configuracion para la anotacion
    String nombre() default "";

}
