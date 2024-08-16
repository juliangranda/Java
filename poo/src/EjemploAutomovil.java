import java.util.Date;

public class EjemploAutomovil {
    public static void main(String[] args) {
        Automovil subaru = new Automovil("Subaru", "Impresa");

        subaru.setCilindrada(2.0);
        subaru.setColor("blanco");

        Automovil mazda = new Automovil("Mazda", "BT-50", "Rojo", 3.0);
        Automovil nissan = new Automovil("Nissan", "Navara", "Gris Oscuro", 3.0, 50);
        Automovil nissan2 = new Automovil("Nissan", "Navara", "Gris Oscuro", 3.0, 50);
        Automovil auto = new Automovil();
        Date fecha = new Date();

        System.out.println(auto.equals(fecha));
        System.out.println(nissan.toString());

        //la referencia en la memoria es diferene.
        System.out.println("son iguales?: " + (nissan == nissan2));
        //SobreEscribio el metodo equals en la clase padre para que fuera true.
        System.out.println("son iguales? con equals: " + (nissan.equals(nissan2)));

        subaru.verDetalles();
        mazda.verDetalles();
        nissan.verDetalles();
        System.out.println(auto.equals(nissan));

        System.out.println(subaru.acelerar(50));
        System.out.println(subaru.frenar());
        System.out.println(mazda.acelerarFrenar(4000));

        System.out.println("kilometro por litro " + subaru.calcularConsumo(300, 0.6f));
        System.out.println("kilometro por litro " + subaru.calcularConsumo(300, 60));
        System.out.println("kilometro por litro " + nissan.calcularConsumo(300, 60));
    }
}
