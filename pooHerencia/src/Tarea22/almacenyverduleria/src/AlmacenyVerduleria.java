import domain.*;

public class AlmacenyVerduleria {
    public static void main(String[] args) {

        Producto[] productos = new Producto[8];

        productos[0] = new Lacteo("yogurt",4000,1,50);
        productos[1] = new Lacteo("Leche Colanta",7000,2,80);

        productos[2] = new Fruta("naranja",1500,0.15,"naranjado");
        productos[3] = new Fruta("manzana",2000.2,0.18,"verde");

        productos[4] = new Limpieza("Limpido",5500,"cloro",0.5);
        productos[5] = new Limpieza("Ajax",8000,"desinfectante",0.8);

        productos[6] = new NoPerecible("Atun Claro",10000,1,108);
        productos[7] = new NoPerecible("Fideos Montecello",12000,1,108);

        for(Producto p: productos){
            System.out.println(p + "\n");

        }
    }
}
