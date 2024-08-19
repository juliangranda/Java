import java.sql.SQLOutput;

public class EjemploAutomovilStatic {
    public static void main(String[] args) {
        Automovil.setCapacidadEstanqueEstatico(45);
        Automovil subaru = new Automovil("Subaru", "Impresa");

        subaru.setMotor(new Motor(2.0,TipoMotor.BENCINA));
        subaru.setEstanque(new Estanque());
        subaru.setColor(Color.BLANCO);
        subaru.setTipo(TipoAutomovil.HATCHBACK);

        Automovil mazda = new Automovil("Mazda", "BT-50", Color.ROJO, new Motor(3.0, TipoMotor.DIESEL));
        mazda.setTipo(TipoAutomovil.PICKUP);
        //mazda.setEstanque(new Estanque());
        Automovil nissan = new Automovil("Nissan", "Navara", Color.GRIS, new Motor(4.0, TipoMotor.DIESEL), new Estanque(50));
        nissan.setTipo(TipoAutomovil.PICKUP);
        Automovil nissan2 = new Automovil("Nissan", "Navara", Color.GRIS, new Motor(3.5,TipoMotor.BENCINA), new Estanque(50));
        nissan2.setTipo(TipoAutomovil.PICKUP);
        Automovil.setColorPatente(Color.AZUL);

        Automovil auto = new Automovil();

        subaru.verDetalles();
        mazda.verDetalles();
        nissan.verDetalles();
        nissan2.verDetalles();
        System.out.println("Automovil.getColorPatente() = " + Automovil.getColorPatente());

        //la forma correcta de llamar el metodo estatico es por medio de la clase
        System.out.println("kilómetros por litros = " + Automovil.calcularConsumoEstatico(300, 60));

        System.out.println("kilómetros por litros = " + subaru.calcularConsumoEstatico(300, 60));
        System.out.println("kilómetros por litros = " + mazda.calcularConsumoEstatico(300, 60));
        System.out.println("kilómetros por litros = " + nissan.calcularConsumoEstatico(300, 60));
        System.out.println("velociad maxima carretera: "+Automovil.VELOCIDAD_MAXIMA_CARRETERA);
        System.out.println("velocidad maxima ciudad: "+Automovil.VELOCIDAD_MAX_CIUDAD);

        TipoAutomovil tipoSubaru = subaru.getTipo();
        System.out.println("tipoSubaru.getNombre() = " + tipoSubaru.getNombre());
        System.out.println("tipoSubaru.getDescripcion() = " + tipoSubaru.getDescripcion());
    }
}
