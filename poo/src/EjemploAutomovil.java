public class EjemploAutomovil {
    public static void main(String[] args) {
        Automovil subaru = new Automovil("Subaru", "Impresa");

        subaru.setCilindrada(2.0);
        subaru.setColor("blanco");

        Automovil mazda = new Automovil("Mazda", "BT-50");
        mazda.setCilindrada(3.0);
        mazda.setColor("Rojo");

        Automovil nissan = new Automovil("Nissan", "");

        subaru.verDetalles();
        mazda.verDetalles();
        System.out.println(subaru.acelerar(50));
        System.out.println(subaru.frenar());
        System.out.println(mazda.acelerarFrenar(4000));

        System.out.println("kilometro por litro " + subaru.calcularConsumo(300, 0.6f));
        System.out.println("kilometro por litro " + subaru.calcularConsumo(300, 60));
    }
}
