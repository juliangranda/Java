import java.util.*;

public class OrdenCompra {
    private Integer id;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private Producto[] productos;
    private static int contadorId;
    private int indiceProductos;

    public OrdenCompra(String descripcion) {
        this.descripcion = descripcion;
        this.id = ++contadorId;
        this.productos = new Producto[4];
    }

    public Integer getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto[] getProductos() {
        return productos;
    }

    //metodos
    public OrdenCompra addProducto(Producto producto){
        if(indiceProductos < this.productos.length){
            productos[indiceProductos++] = producto;
        }
        return this;
    }

    public int Total(){
        int total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }

}

