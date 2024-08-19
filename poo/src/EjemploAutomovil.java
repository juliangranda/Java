import java.util.Date;

public class EjemploAutomovil {
    public static void main(String[] args) {
        Automovil subaru = new Automovil("Subaru", "Impresa");

        Motor motorSubaru = new Motor(2.0,TipoMotor.BENCINA);
        Motor motorMazda = new Motor(3.0, TipoMotor.DIESEL);
        subaru.setMotor(motorSubaru);
        subaru.setEstanque(new Estanque());
        subaru.setColor(Color.BLANCO);

        Automovil mazda = new Automovil("Mazda", "BT-50", Color.ROJO, motorMazda);
        mazda.setEstanque(new Estanque(45));

        System.out.println("mazda.getFabricante() =  " + mazda.getFabricante());
        Automovil nissan = new Automovil("Nissan", "Navara", Color.GRIS,
                new Motor(4.0, TipoMotor.DIESEL), new Estanque(50));
        Automovil nissan2 = new Automovil("Nissan", "Navara", Color.GRIS,
                new Motor(3.5,TipoMotor.BENCINA), new Estanque(50));

        nissan2.setColor(Color.AMARILLO);
        Automovil.setColorPatente(Color.AZUL);
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
        System.out.println("kilometro por litro " + subaru.calcularConsumo(300, 60f));
        System.out.println("kilometro por litro " + nissan.calcularConsumo(300, 60));
    }
}
