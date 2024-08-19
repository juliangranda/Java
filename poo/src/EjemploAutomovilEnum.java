public class EjemploAutomovilEnum {
    public static void main(String[] args) {
        Automovil.setCapacidadEstanqueEstatico(45);
        Automovil subaru = new Automovil("Subaru", "Impresa");

        subaru.setMotor(new Motor(2.0,TipoMotor.BENCINA));
        subaru.setEstanque(new Estanque());
        subaru.setColor(Color.BLANCO);
        subaru.setTipo(TipoAutomovil.HATCHBACK);

        Automovil mazda = new Automovil("Mazda", "BT-50", Color.ROJO, new Motor(3.0, TipoMotor.DIESEL));
        mazda.setEstanque(new Estanque(45));
        mazda.setTipo(TipoAutomovil.PICKUP);
        System.out.println("mazda.getFabricante() = " + mazda.getFabricante());

        TipoAutomovil tipo = subaru.getTipo();
        System.out.println("tipoSubaru.getNombre() = " + tipo.getNombre());
        System.out.println("tipoSubaru.getDescripcion() = " + tipo.getDescripcion());

        tipo = mazda.getTipo();
        //version resumida de un switch case dado a laversion 13+ de java por eso el (->)
        //y asu vez se evita el uso de break.
        switch(tipo){
            case CONVERTIBLE ->
                    System.out.println("El automovil es deportivo y descapotable de dos puertas");
            case COUPE ->
                    System.out.println("Es un automovil pequeño de dos puertas y típicamente deportivo");
            case FURGON ->
                    System.out.println("Es un automovil utilitario de transporte, de empresas");
            case HATCHBACK ->
                    System.out.println("Es un automovil mediano compacto, aspecto deportivo");
            case PICKUP ->
                    System.out.println("Es un automovil de doble cabina o camioneta");
            case SEDAN ->
                    System.out.println("Es un automovil mediano");
            case STATION_WAGON ->
                    System.out.println("Es un automovil más grande, con maleta grande...");
        }
        //retorna un array que contine las constantes del enum. TipoAutomovil.values();
        TipoAutomovil[] tipos = TipoAutomovil.values();
        for(TipoAutomovil ta: tipos){
            System.out.print(ta + " => " + ta.name() + ", " +
                    ta.getNombre() + ", " +
                    ta.getDescripcion() + ", " +
                    ta.getNumeroPuerta());
            System.out.println();
        }
    }
}

