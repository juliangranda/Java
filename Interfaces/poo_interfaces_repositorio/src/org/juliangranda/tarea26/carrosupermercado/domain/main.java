package org.juliangranda.tarea26.carrosupermercado.domain;

public class main {
    public static void main(String[] args) {

        BolsaSupermercado<Lacteo> bolsaLacteo = new BolsaSupermercado<>();
        BolsaSupermercado<Fruta> bolsaFruta = new BolsaSupermercado<>();
        BolsaSupermercado<Limpieza> bolsaLimpieza = new BolsaSupermercado<>();
        BolsaSupermercado<NoPerecible> bolsaNoPerecible = new BolsaSupermercado<>();

        Fruta fruta1 = new Fruta("Naranja",1500,20,"Naranjada");
        Fruta fruta2 = new Fruta("Pera",1000,15,"verde");
        Fruta fruta3 = new Fruta("Manzana",1500,15,"Rojo");
        Fruta fruta4 = new Fruta("Fresa",1000,5,"Rojo");
        Fruta fruta5 = new Fruta("Mango",2000,18,"Mezcla");

        Limpieza limpieza1 = new Limpieza("Blancox",5000,"Cloro",1.5);
        Limpieza limpieza2 = new Limpieza("Fab",3000,"Jaban",1);
        Limpieza limpieza3 = new Limpieza("Fabuloso",4000,"Perfume",1.5);
        Limpieza limpieza4 = new Limpieza("Suavitel",3000,"Suavizante",1);
        Limpieza limpieza5= new Limpieza("AJAX",7000,"Mezcla",2);

        Lacteo prodL1 = new Lacteo("Leche Colanta",3000,1,20);
        Lacteo prodL2 = new Lacteo("Quesito",5000,2,60);
        Lacteo prodL3 = new Lacteo("Cuajada",6000,1,40);
        Lacteo prodL4 = new Lacteo("yogurt",2500,1,10);
        Lacteo prodL5 = new Lacteo("Avena",1000,1,5);

        NoPerecible noPerecible1 = new NoPerecible("Pasta",2000,5,30);
        NoPerecible noPerecible2 = new NoPerecible("Arroz",4500,300,300);
        NoPerecible noPerecible3 = new NoPerecible("Cage",15000,250,10);
        NoPerecible noPerecible4 = new NoPerecible("Chocolate",2000,10,60);
        NoPerecible noPerecible5 = new NoPerecible("Miel",5000,100,50);

        bolsaLacteo.addProducto(prodL1);
        bolsaLacteo.addProducto(prodL2);
        bolsaLacteo.addProducto(prodL3);
        bolsaLacteo.addProducto(prodL4);
        bolsaLacteo.addProducto(prodL5);

        bolsaFruta.addProducto(fruta1);
        bolsaFruta.addProducto(fruta2);
        bolsaFruta.addProducto(fruta3);
        bolsaFruta.addProducto(fruta4);
        bolsaFruta.addProducto(fruta5);

        bolsaLimpieza.addProducto(limpieza1);
        bolsaLimpieza.addProducto(limpieza2);
        bolsaLimpieza.addProducto(limpieza3);
        bolsaLimpieza.addProducto(limpieza4);
        bolsaLimpieza.addProducto(limpieza5);

        bolsaNoPerecible.addProducto(noPerecible1);
        bolsaNoPerecible.addProducto(noPerecible2);
        bolsaNoPerecible.addProducto(noPerecible3);
        bolsaNoPerecible.addProducto(noPerecible4);
        bolsaNoPerecible.addProducto(noPerecible5);

        System.out.println("-------------------Lacteo------------------------");
        for(Lacteo l: bolsaLacteo.getProductos()){
            System.out.println("Nombre: "+l.getNombre());
            System.out.println("Precio: "+l.getPrecio());
            System.out.println("Cantidad: "+l.getCantidad());
            System.out.println("Proteinas: "+l.getProteinas());
            System.out.println();
        }

        System.out.println("--------------------Fruta---------------------------");
        for(Fruta f: bolsaFruta.getProductos()){
            System.out.println("nombre: "+f.getNombre());
            System.out.println("precio: " + f.getPrecio());
            System.out.println("peso: "+f.getPeso());
            System.out.println("color: "+ f.getColor());
            System.out.println();
        }

        System.out.println("------------------Limpieza-----------------------------");
        for(Limpieza l: bolsaLimpieza.getProductos()){
            System.out.println("nombre: "+l.getNombre());
            System.out.println("precio: " + l.getPrecio());
            System.out.println("componente: "+l.getComponentes());
            System.out.println("litros: "+ l.getLitros());
            System.out.println();
        }

        System.out.println("------------------No Perecible-------------------");
        for(NoPerecible np: bolsaNoPerecible.getProductos()){
            System.out.println("nombre: "+ np.getNombre());
            System.out.println("precio: "+ np.getPrecio());
            System.out.println("contenido: "+np.getContenido());
            System.out.println("calorias: "+np.getCalorias());
            System.out.println();
        }



    }
}
