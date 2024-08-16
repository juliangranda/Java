public class EjemploAutomovil {
    public static void main(String[] args) {
        Automovil subaru = new Automovil();
        subaru.fabricante = "Subaru";
        subaru.modelo = "Impresa";
        subaru.cilindrada = 2.0;
        subaru.color = "blanco";

        Automovil mazda = new Automovil();
        mazda.fabricante = "Mazda";
        mazda.modelo = "BT-50";
        mazda.cilindrada = 3.0;
        mazda.color = "Rojo";

        subaru.verDetalles();
        mazda.verDetalles();
        System.out.println(subaru.acelerar(50));
        System.out.println(subaru.frenar());
        System.out.println(mazda.acelerarFrenar(4000));

        System.out.println("kilometro por litro " + subaru.calcularConsumo(300, 0.6f));
        System.out.println("kilometro por litro " + subaru.calcularConsumo(300, 60));
    }
}
