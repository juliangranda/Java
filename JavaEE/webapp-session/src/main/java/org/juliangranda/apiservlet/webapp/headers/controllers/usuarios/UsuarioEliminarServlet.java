package org.juliangranda.apiservlet.webapp.headers.controllers.usuarios;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.juliangranda.apiservlet.webapp.headers.models.Usuario;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

import org.juliangranda.apiservlet.webapp.headers.services.ProductoService;
import org.juliangranda.apiservlet.webapp.headers.services.UsuarioService;
import org.juliangranda.apiservlet.webapp.headers.services.UsuarioServiceImpl;

@WebServlet("/usuarios/eliminar")
public class UsuarioEliminarServlet extends HttpServlet {

    @Inject
    private UsuarioService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException e) {
            id = 0L;
        }
        if (id > 0) {
            Optional<Usuario> o = service.porId(id);
            if (o.isPresent()) {
                service.eliminar(id);
                resp.sendRedirect(req.getContextPath()+ "/usuarios");
            } else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "No existe el usuarios en la base de datos!");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Error el id es null, se debe enviar como parametro en la url!");
        }
    }
}
