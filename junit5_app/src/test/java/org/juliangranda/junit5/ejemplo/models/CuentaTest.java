package org.juliangranda.junit5.ejemplo.models;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    //la anotacion @Test nos permite ejecutar una prueba/test del metodo, es obligatoria.
    //click derecho + generate nos permite crear nuestro metodos para test con @Test.

    @Test
    void testNombreCuenta(){
        Cuenta cuenta = new Cuenta("Andres",new BigDecimal("1000.123456"));
        //cuenta.setPersona("Andres");

        //validando algo
        String esperado = "Andres";
        String real = cuenta.getPersona();
        //Assertions.assertEquals(esperado,real);
        assertEquals(esperado,real);
        assertTrue(real.equals("Andres"));

    }

}