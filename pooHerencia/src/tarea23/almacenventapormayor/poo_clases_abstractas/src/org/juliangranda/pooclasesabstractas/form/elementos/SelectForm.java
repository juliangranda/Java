package org.juliangranda.pooclasesabstractas.form.elementos;

import org.juliangranda.pooclasesabstractas.form.elementos.select.Opcion;
import java.util.*;

public class SelectForm extends ElementoForm{

    //List es de Api Collections.
    private List<Opcion> opciones;

    public SelectForm(String nombre) {
        super(nombre);
        this.opciones = new ArrayList<Opcion>();
    }

    public SelectForm(String nombre, List<Opcion> opciones) {
        super(nombre);
        this.opciones = opciones;
    }

    //SelectForm actua como el tipo de retorno de la funcion.
    public SelectForm addOpcion(Opcion opcion){
        //agregar elementos a la List.
        this.opciones.add(opcion);
        return this;
    }


    @Override
    public String dibujarHtml() {
        StringBuilder sb =  new StringBuilder("<select ");
        sb.append("name='")
                .append(this.nombre)
                .append("'>");

        for(Opcion opcion: this.opciones){
            sb.append("\n<option value='")
                    .append(opcion.getValor())
                    .append("'");
            if(opcion.isSelected()){
                sb.append(" selected");
                this.valor = opcion.getValor();
            }
            sb.append(">")
                    .append(opcion.getNombre())
                    .append("</option>");
        }
        sb.append("</select>");
        return sb.toString();
    }
}
