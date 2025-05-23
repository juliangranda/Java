package org.juliangranda.apiservlet.webapp.headers.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.juliangranda.apiservlet.webapp.headers.services.LoginService;
import org.juliangranda.apiservlet.webapp.headers.services.LoginServiceCookieImpl;
import org.juliangranda.apiservlet.webapp.headers.services.LoginServiceSessionImpl;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Inject
    private  LoginService auth;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Optional<String> username = auth.getUsername(req);
        if(username.isPresent()){
            HttpSession session = req.getSession();
            //eliminar la session
            session.invalidate();
        }
        resp.sendRedirect(req.getContextPath() + "/login.html");

    }
}
