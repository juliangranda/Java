package org.juliangranda.junit5.ejemplo.models;

import org.juliangranda.junit5.ejemplo.exceptions.DineroInsuficienteException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    //la anotacion @Test nos permite ejecutar una prueba/test del metodo, es obligatoria.
    //click derecho + generate nos permite crear nuestro metodos para test con @Test.

    //BigDecimal es como un double de mayor tamaño y con una precision superior.
    //se puede usar en bancos o temas relacionados con cuentas o negocios.

    @Test
    void testNombreCuenta(){
        Cuenta cuenta = new Cuenta("Andres",new BigDecimal("1000.123456"));
        //cuenta.setPersona("Andres");

        //validando algo
        String esperado = "Andres";
        String real = cuenta.getPersona();
        assertNotNull(real);
        //Assertions.assertEquals(esperado,real);
        assertEquals(esperado,real);
        assertTrue(real.equals("Andres"));
    }

    @Test
    void testSaldoCuenta(){
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
        assertNotNull(cuenta.getSaldo());
        //doubleValue = convierte un BigDecimal a un double.
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);

    }

    @Test
    void testReferenciaCuenta() {
        Cuenta cuenta = new Cuenta("John Doe", new BigDecimal("8900.9997"));
        Cuenta cuenta2 = new Cuenta("John Doe", new BigDecimal("8900.9997"));
        //assertNotEquals(cuenta,cuenta2);
        //Equals se hizo sobreescritura de equals en Clase Cuenta.
        assertEquals(cuenta,cuenta2);
    }

    @Test
    void testDebitoCuenta() {
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
        cuenta.debito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(900, cuenta.getSaldo().intValue());
        assertEquals("900.12345",cuenta.getSaldo().toPlainString());
    }

    @Test
    void testCreditoCuenta() {
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
        cuenta.credito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(1100, cuenta.getSaldo().intValue());
        assertEquals("1100.12345",cuenta.getSaldo().toPlainString());
    }

    @Test
    void testDineroSuficienteExceptionCuenta() {
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
        Exception exception = assertThrows(DineroInsuficienteException.class, () -> {
           cuenta.debito(new BigDecimal(1500));
        });
        String actual = exception.getMessage();
        String esperado = "Dinero Insuficiente";
        assertEquals(esperado,actual);
    }
}