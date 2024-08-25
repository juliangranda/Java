package org.juliangranda.poointerface.dominio.interfaces;

import java.util.Date;

public interface ILibro {

    Date getFechaPublicacion();
    String getAuthor();
    String getTitulo();
    String getEditorial();

}
