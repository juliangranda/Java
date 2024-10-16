package org.juliangranda.apiservlet.webapp.form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;

// "/registro/ debe de coincidir con el nombre del formulario en index.html
@WebServlet("/registro")
public class FormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String pais = req.getParameter("pais");
        String[] lenguajes = req.getParameterValues("lenguajes");
        String[] roles = req.getParameterValues("roles");

        String idioma = req.getParameter("idioma");
        String habilitar = req.getParameter("habilitar");
        String secreto = req.getParameter("secreto");
        try (PrintWriter out = resp.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("    <head>");
            out.println("        <meta charset=\"UTF-8\">");
            out.println("        <title>Resultado Form</title>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("    <h1>Resultado Form</h1>");

            out.println(        "<ul>");
            out.println(             "<li>Username: " + username + "</li>");
            out.println(             "<li>Password: " + password + "</li>");
            out.println(             "<li>Email: " + email + "</li>");
            out.println(             "<li>Pais: " + pais + "</li>");
            out.println(             "<li>Lenguajes: <ul>");
            Arrays.asList(lenguajes).forEach(lenguaje -> {
                out.println("                   <li>" + lenguaje + "</li>");
            });
            out.println(             "</ul></li>");

            out.println("            <li>Roles: <ul>");
            Arrays.asList(roles).forEach(role -> {
                out.println("                   <li>" + role + "</li>");
            });
            out.println("            </ul></li>");
            out.println("            <li>Idioma: " + idioma + "</li>");
            out.println("            <li>Habilitar:" + habilitar + "</li>");
            out.println("            <li>Secreto:" + secreto + "</li>");
            out.println(        "</ul>");
            out.println("    </body>");
            out.println("</html>");
        }

    }
}
