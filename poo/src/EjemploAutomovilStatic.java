public class EjemploAutomovilStatic {
    public static void main(String[] args) {
        Automovil subaru = new Automovil("Subaru", "Impresa");

        subaru.setCilindrada(2.0);
        subaru.setColor("blanco");

        Automovil mazda = new Automovil("Mazda", "BT-50", "Rojo", 3.0);
        Automovil nissan = new Automovil("Nissan", "Navara", "Gris Oscuro", 3.0, 50);
        Automovil nissan2 = new Automovil("Nissan", "Navara", "Gris Oscuro", 3.0, 50);
        Automovil.setColorPatente("verde");

        Automovil auto = new Automovil();

        subaru.verDetalles();
        mazda.verDetalles();
        nissan2.verDetalles();
        System.out.println("Automovil.getColorPatente() = " + Automovil.getColorPatente());

    }
}
