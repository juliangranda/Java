import java.util.Arrays;
import java.util.Date;

public class EjemploOrdenes {
    public static void main(String[] args) {

        OrdenCompra orden1 = new OrdenCompra("Video Juegos");
        orden1.setFecha(new Date());
        orden1.setCliente(new Cliente("Julian","Gomez"));
        orden1.addProducto(new Producto("RiotGames","League of legends",100))
                .addProducto(new Producto("Tencent","lol pirata",50))
                .addProducto(new Producto("Supercell","castle clash",75))
                .addProducto(new Producto("Epic Games", "sims",200));

        OrdenCompra orden2 = new OrdenCompra("componentes pc");
        orden2.setFecha(new Date());
        orden2.setCliente(new Cliente("David","Granda"));
        orden2.addProducto(new Producto("Nvidia","RTX3600",300))
                .addProducto(new Producto("Kalley","Teclado",30))
                .addProducto(new Producto("CZF", "Mouse Gaming", 20))
                .addProducto(new Producto("lenovo", "pantalla", 80));

        OrdenCompra orden3 = new OrdenCompra("Libros");
        orden3.setFecha(new Date());
        orden3.setCliente(new Cliente("Valentina","Gomez"));
        orden3.addProducto(new Producto("Fabrica de libros","Psicoanalista",100))
                .addProducto(new Producto("Bubok","100 años de Soledad", 500))
                .addProducto(new Producto("Planeta","Origen",60))
                .addProducto(new Producto("Paidos","Habitos Atomicos",75));

        //arreglo con toda la informacion de las ordenes de los productos.
        OrdenCompra[] ordenes ={orden1,orden2,orden3};
        for (OrdenCompra orden : ordenes) {
            System.out.println(orden);
            System.out.println("Id: "+orden.getId());
            System.out.println("Cliente: "+orden.getCliente());
            System.out.println("Descripcion: "+orden.getDescripcion());
            System.out.println("Fecha: "+orden.getFecha());
            System.out.println("Precio total: "+orden.Total());

            int i = 1;
            for (Producto p:orden.getProductos()) {
                System.out.println("Producto: "+i+": "+"fabricate: "+p.getFabricante() + " *nombre: "+ p.getNombre() + " *Precio:$ "+ p.getPrecio() );
                i++;
            }
        }


    }
}
