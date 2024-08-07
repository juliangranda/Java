import java.util.Arrays;

public class EjemploForInverso {
    public static void main(String[] args) {

        //String[] productos = new String[7];
        String[] productos = { "Kingston Pendrive 64GB", "Samsung Galaxy",
                "Disco Duro SSD Samsung Externo",
                "Asus Notebook", "Macbook Air",
                "Chromecast 4ta generación", "Bicicleta Oxford" };

        int total = productos.length;

        Arrays.sort(productos);
        System.out.println("=== Usando for ===");
        for(int i = 0; i < total; i++){
            System.out.println("para indice " + i + " : " + productos[i]);
        }

        System.out.println("=== Usando for inverso ===");
        for(int i = 0; i < total; i++){
            System.out.println("para i = " + (total-1-i) + " valor: " + productos[total-1-i]);
        }

        System.out.println("=== Usando for inverso 2 ===");
        for(int i = total - 1; i >= 0; i--){
            System.out.println("para i = " + i + " valor " + productos[i]);
        }

    }
}
