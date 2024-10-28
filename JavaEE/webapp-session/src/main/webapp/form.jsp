<%@page contentType="text/html" pageEncoding="UTF-8"
import="java.util.*, org.juliangranda.apiservlet.webapp.headers.models.*"%>
<%
List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario producto</title>
</head>
<body>
    <h1>Formulario producto</h1>
    <form action="<%=request.getContextPath()%>/productos/form" method="post">
        <div>
            <label for="nombre">Nombre</label>
            <div>
                <input type="text" name="nombre" id="nombre">
            </div>
        </div>

        <div>
            <label for="precio">Precio</label>
            <div>
                <input type="number" name="precio" id="precio">
            </div>
        </div>

        <div>
            <label for="sku">sku</label>
            <div>
                <input type="text" name="sku" id="sku">
            </div>
        </div>

        <div>
            <label for="fecha_registro">Fecha Registro</label>
            <div>
                <input type="date" name="fecha_registro" id="fecha_registro">
            </div>
        </div>

        <div>
            <label for="categoria">Categoria</label>
            <div>
                <select name="categoria" id="categoria">
                    <option value="">--- Seleccionar ---</option>
                    <% for(Categoria c: categorias){%>
                    <option value="<%=c.getId()%>"><%=c.getNombre()%></option>
                    <%}%>
                </select>
            </div>
        </div>

        <div><input type="submit" value="Crear"></div>
    </form>
</body>
</html>