package org.juliangranda.java.jdbc.repositorio;

import org.juliangranda.java.jdbc.model.Categoria;
import org.juliangranda.java.jdbc.model.Producto;
import org.juliangranda.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorioImpl implements Repositorio<Producto> {

    private Connection conn;

    public ProductoRepositorioImpl(Connection conn) {
        this.conn = conn;
    }

    public ProductoRepositorioImpl() {
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Producto> listar() throws SQLException {
        List<Producto> productos = new ArrayList<>();

        try(
                Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT p.*, c.nombre as categoria FROM productos as p " +
                    "inner join categorias as c ON (p.categoria_id = c.id)")){
            while(rs.next()){
                Producto p = crearProducto(rs);
                productos.add(p);
            }

        }
        return productos;
    }

    //try: solo puede usar argumentos de tipo recurso(Statement).
    @Override
    public Producto porId(Long id) throws SQLException {
        Producto producto = null;
        try(
                PreparedStatement stmt = conn
                .prepareStatement("SELECT p.*, c.nombre as categoria FROM productos as p " +
                        "inner join categorias as c ON (p.categoria_id = c.id) WHERE p.id = ? ")){
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    producto = crearProducto(rs);
                }
            }

        }
        return producto;
    }

    @Override
    public Producto guardar(Producto producto) throws SQLException {
        String sql;
        if (producto.getId() != null && producto.getId()>0) {
            sql = "UPDATE productos SET nombre=?, precio=?, categoria_id=?, sku=? WHERE id=?";
        } else {
            sql = "INSERT INTO productos(nombre,precio,categoria_id, sku, fecha_registro) VALUES(?,?,?,?,?)";
        }
        try(
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, producto.getNombre());
            stmt.setLong(2,producto.getPrecio());
            stmt.setLong(3,producto.getCategoria().getId());
            stmt.setString(4, producto.getSku());

            if (producto.getId() != null && producto.getId()>0) {
                stmt.setLong(5,producto.getId());

            }else{
                //hay conversion de java.util a java.sql,
                // pero no es necesario cuando es java.sql a java.util porque el sql hereda de java.util.
                //esto es por insertar datos desde java a sql-basedatos.
                stmt.setDate(5,new Date(producto.getFechaRegistro().getTime()));
            }

            stmt.executeUpdate();

            if(producto.getId() == null){
                try(ResultSet rs = stmt.getGeneratedKeys()){
                    if(rs.next()){
                        producto.setId(rs.getLong(1));
                    }
                }
            }
            return producto;
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        try(
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM productos WHERE id=?")){
            stmt.setLong(1,id);
            stmt.executeUpdate();

        }
    }

    private static Producto crearProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setId(rs.getLong("id"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getInt("precio"));
        p.setFechaRegistro(rs.getDate("fecha_registro"));
        p.setSku(rs.getString("sku"));
        Categoria categoria = new Categoria();
        categoria.setId(rs.getLong("categoria_id"));
        categoria.setNombre(rs.getString("categoria"));
        p.setCategoria(categoria);
        return p;
    }
}
