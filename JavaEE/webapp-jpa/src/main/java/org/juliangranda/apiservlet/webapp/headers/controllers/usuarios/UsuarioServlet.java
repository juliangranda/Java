package org.juliangranda.apiservlet.webapp.headers.controllers.usuarios;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.juliangranda.apiservlet.webapp.headers.models.entities.Usuario;
import org.juliangranda.apiservlet.webapp.headers.services.LoginService;
import org.juliangranda.apiservlet.webapp.headers.services.LoginServiceSessionImpl;
import org.juliangranda.apiservlet.webapp.headers.services.UsuarioService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@WebServlet("/usuarios")
public class UsuarioServlet extends HttpServlet {

    @Inject
    private UsuarioService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Usuario> usuarios = service.listar();

        LoginService auth = new LoginServiceSessionImpl();
        Optional<String> usernameOptional = auth.getUsername(req);

        req.setAttribute("usuarios", usuarios);
        req.setAttribute("username", usernameOptional);

        req.setAttribute("title", req.getAttribute("title") + ": Listado de usuarios");
        getServletContext().getRequestDispatcher("/usuarios/listar.jsp").forward(req, resp);
    }
}