package org.juliangranda.apiservlet.webapp.headers.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.juliangranda.apiservlet.webapp.headers.models.Carro;
import org.juliangranda.apiservlet.webapp.headers.models.ItemCarro;
import org.juliangranda.apiservlet.webapp.headers.models.Producto;
import org.juliangranda.apiservlet.webapp.headers.services.ProductoService;
import org.juliangranda.apiservlet.webapp.headers.services.ProductoServiceImpl;
import org.juliangranda.apiservlet.webapp.headers.services.ProductoServiceJdbcImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/carro/agregar")
public class AgregarCarroServlet extends HttpServlet {

    @Inject
    private Carro carro;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long id = Long.parseLong(req.getParameter("id"));
        Connection conn = (Connection) req.getAttribute("conn");
        ProductoService service = new ProductoServiceJdbcImpl(conn);
        Optional<Producto> producto = service.porId(id);
        if(producto.isPresent()){
            ItemCarro item = new ItemCarro(1, producto.get());
//            HttpSession session = req.getSession();
//            Carro carro = (Carro) session.getAttribute("carro");
            carro.addItemCarro(item);
        }
        resp.sendRedirect(req.getContextPath() + "/carro/ver");
    }
}
