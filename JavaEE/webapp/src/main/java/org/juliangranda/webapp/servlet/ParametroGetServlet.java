package org.juliangranda.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/parametros/url-get")
public class ParametroGetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String saludo = req.getParameter("saludo");
        String nombre = req.getParameter("nombre");
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("    <head>");
        out.println("        <meta charset=\"UTF-8\">");
        out.println("        <title>parametros Get de Tarea1 webapp</title>");
        out.println("    </head>");
        out.println("    <body>");
        out.println("    <h1>parametros Get de la url</h1>");
        if(saludo != null && nombre != null){
            out.println("    <h2>El saludo enviado es: " + saludo + " " + nombre + "</h2>");
        }else if(saludo != null){
            out.println("    <h2>El saludo enviado es: " + saludo + "</h2>");
        } else if (nombre != null) {
            out.println("    <h2>Hola mi nombre es: " + nombre + "</h2>");
        } else{
            out.println("<h2>no se han pasado los parametros saludo ni nombre");
        }
        try{
            int codigo = Integer.parseInt(req.getParameter("codigo"));
            out.println("<h3>El codigo enviado es : " + codigo + "</h3>");
        }catch(NumberFormatException e){
            out.println("<h3>El codigo no ha sido enviado, es null</h3>");
        }

        out.println("    </body>");
        out.println("</html>");
        out.close();
    }
}
