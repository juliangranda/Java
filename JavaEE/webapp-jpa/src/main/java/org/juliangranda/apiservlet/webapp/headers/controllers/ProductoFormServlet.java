package org.juliangranda.apiservlet.webapp.headers.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.juliangranda.apiservlet.webapp.headers.configs.ProductoServicePrincipal;
import org.juliangranda.apiservlet.webapp.headers.models.entities.Categoria;
import org.juliangranda.apiservlet.webapp.headers.models.entities.Producto;
import org.juliangranda.apiservlet.webapp.headers.services.ProductoService;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@WebServlet("/productos/form")
public class ProductoFormServlet extends HttpServlet {

    @Inject
    @ProductoServicePrincipal
    private ProductoService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id;
        try{
            id = Long.parseLong(req.getParameter("id"));
        }catch (NumberFormatException e){
            id = 0L;
        }
        Producto producto = new Producto();
        producto.setCategoria(new Categoria());
        if(id > 0){
            Optional<Producto> o = service.porId(id);
            if(o.isPresent()){
                producto = o.get();
            }
        }
        req.setAttribute("categorias", service.listarCategoria());
        req.setAttribute("producto",producto);
        req.setAttribute("title", req.getAttribute("title") + ": Formulario de productos");
        getServletContext().getRequestDispatcher("/form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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

        LocalDate fecha;
        try{
            fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }catch(DateTimeParseException e){
            fecha = null;
        }
        Long id;
        try{
            id = Long.valueOf(req.getParameter("id"));
        }catch(NumberFormatException e){
            id = null;
        }
        Producto producto = new Producto();
        producto.setId(id);
        producto.setNombre(nombre);
        producto.setSku(sku);
        producto.setPrecio(precio);
        producto.setFechaRegistro(fecha);

        Categoria categoria = new Categoria();
        categoria.setId(categoriaId);
        producto.setCategoria(categoria);

        if(errores.isEmpty()) {
            service.guardar(producto);
            resp.sendRedirect(req.getContextPath() + "/productos");
        }else{
            req.setAttribute("errores",errores);
            req.setAttribute("categorias", service.listarCategoria());
            req.setAttribute("producto",producto);
            req.setAttribute("title", req.getAttribute("title") + ": Formulario de productos");
            getServletContext().getRequestDispatcher("/form.jsp").forward(req,resp);
        }
    }
}
