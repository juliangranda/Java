package org.juliangranda.webapp.ejb.controllers;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.juliangranda.webapp.ejb.service.ServiceEjb;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;

@WebServlet("/index")
public class EjemploServlet extends HttpServlet {

//    @Inject
//    private ServiceEjb service;
//
//    @Inject
//    private ServiceEjb service2;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServiceEjb service = null;
        ServiceEjb service2 = null;
        try {

            InitialContext ctx = new InitialContext();
            service = (ServiceEjb) ctx.lookup("java:global/webapp-ejb/ServiceEjb!org.juliangranda.webapp.ejb.service.ServiceEjb");
            service2 = (ServiceEjb) ctx.lookup("java:global/webapp-ejb/ServiceEjb!org.juliangranda.webapp.ejb.service.ServiceEjb");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        System.out.println("service es igual a service2 = " + service.equals(service2));
        req.setAttribute("saludo", service.saludar("Andres"));
        req.setAttribute("saludo2", service2.saludar("Jhon"));
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
