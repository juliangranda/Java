package org.juliangranda.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.juliangranda.apiservlet.webapp.headers.models.Categoria;
import org.juliangranda.apiservlet.webapp.headers.models.Producto;
import org.juliangranda.apiservlet.webapp.headers.services.ProductoService;
import org.juliangranda.apiservlet.webapp.headers.services.ProductoServiceJdbcImpl;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/productos/form")
public class ProductoFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        ProductoService service = new ProductoServiceJdbcImpl(conn);
        req.setAttribute("categorias", service.listarCategoria());
        getServletContext().getRequestDispatcher("/form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection conn = (Connection) req.getAttribute("conn");
        ProductoService service = new ProductoServiceJdbcImpl(conn);
        String nombre = req.getParameter("nombre");

        Integer precio;
        try {
            precio = Integer.valueOf(req.getParameter("precio"));
        } catch (NumberFormatException e){
            precio = 0;
        }

        String sku = req.getParameter("sku");
        String fechaStr = req.getParameter("fecha_registro");
        Long categoriaId;
        try{
            categoriaId = Long.valueOf(req.getParameter("categoria"));
        }catch(NumberFormatException e){
            categoriaId = 0L;
        }

        Map<String, String> errores = new HashMap<>();
        if(nombre == null || nombre.isBlank()){
            errores.put("nombre", "el nombre es requerido");
        }
        if(sku == null || sku.isBlank()){
            errores.put("sku","el sku es requerido");
        }else if (sku.length() > 10){
            errores.put("sku","el sku debe tener maximo 10 caracteres");
        }
        if(sku == null || sku.isBlank()){
            errores.put("sku","el sku es requerido");
        }
        if(fechaStr == null || fechaStr.isBlank()){
            errores.put("fecha_registro","la fecha es requerida");
        }
        if(precio.equals(0)){
            errores.put("precio","el precio es requerido");
        }
        if(categoriaId.equals(0L)){
            errores.put("categoria","la categoria es requerida");
        }
        if(errores.isEmpty()) {

            LocalDate fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Producto producto = new Producto();
            producto.setSku(nombre);
            producto.setSku(sku);
            producto.setPrecio(precio);
            producto.setFechaRegistro(fecha);

            Categoria categoria = new Categoria();
            categoria.setId(categoriaId);
            producto.setCategoria(categoria);

            service.guardar(producto);
            resp.sendRedirect(req.getContextPath() + "/productos");
        }else{
            req.setAttribute("errores",errores);
            doGet(req,resp);
        }
    }
}
