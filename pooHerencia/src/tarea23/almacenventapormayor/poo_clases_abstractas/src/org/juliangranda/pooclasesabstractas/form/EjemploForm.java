package org.juliangranda.pooclasesabstractas.form;

import org.juliangranda.pooclasesabstractas.form.elementos.*;
import org.juliangranda.pooclasesabstractas.form.elementos.select.Opcion;

import java.util.*;

public class EjemploForm {
    public static void main(String[] args) {

        InputForm username = new InputForm("username");
        InputForm password = new InputForm("clave", "password");
        InputForm email = new InputForm("email", "email");
        InputForm edad = new InputForm("edad", "number");

        TextareaForm experiencia = new TextareaForm("exp", 5, 9);

        SelectForm lenguaje = new SelectForm("lenguaje");
        Opcion java = new Opcion("1","Java");
        lenguaje.addOpcion(java)
                .addOpcion(new Opcion("2", "Python").setSelected())
                .addOpcion(new Opcion("3", "JavaScript"))
                .addOpcion(new Opcion("4", "TypeScript"))
                .addOpcion(new Opcion("5", "PHP"));

        //Clases anonimas
        ElementoForm saludar = new ElementoForm("saludo"){
            @Override
            public String dibujarHtml() {
                return "<input disabled name='"+this.nombre+"' value=\"" +this.valor+ "\">";
            }
        };

        saludar.setValor("Hola que tal este campo está deshabilitado!");
        username.setValor("john.doe");
        password.setValor("a1b2c3");
        email.setValor("john.doe@correo.com");
        edad.setValor("28");
        experiencia.setValor("... más de 10 años de experiencia ...");
        //java.setSelected(true);

        List<ElementoForm> elementos = Arrays.asList(username,
                password,
                email,
                edad,
                experiencia,
                lenguaje,
                saludar
                );

        elementos.forEach(e -> {
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        });

    }
}
