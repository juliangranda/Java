public class EjemploAutomovilRelacionesObjetos {
    public static void main(String[] args) {
        Rueda[] ruedasSub = new Rueda[5];
        ruedasSub[0] = new Rueda("yukohama",16,7.5);
        ruedasSub[1] = new Rueda("yukohama",16,7.5);
        ruedasSub[2] = new Rueda("yukohama",16,7.5);
        ruedasSub[3] = new Rueda("yukohama",16,7.5);
        ruedasSub[4] = new Rueda("yukohama",16,7.5);

        Persona conductorSubaru = new Persona("luci", "martinez");
        Automovil subaru = new Automovil("Subaru", "Impresa");

        subaru.setMotor(new Motor(2.0,TipoMotor.BENCINA));
        subaru.setEstanque(new Estanque());
        subaru.setColor(Color.BLANCO);
        subaru.setTipo(TipoAutomovil.HATCHBACK);
        subaru.setConductor(conductorSubaru);
        subaru.setRuedas(ruedasSub);

        Rueda[] ruedasMaz = {new Rueda("michelin", 18, 10.5),
                new Rueda("michelin", 18, 10.5),
                new Rueda("michelin", 18, 10.5),
                new Rueda("michelin", 18, 10.5),
                new Rueda("michelin", 18, 10.5)
        };

        Persona pato = new Persona("Pato", "Rodriguez");
        Automovil mazda = new Automovil("Mazda", "BT-50", Color.ROJO, new Motor(3.0, TipoMotor.DIESEL));
        mazda.setTipo(TipoAutomovil.PICKUP);
        mazda.setEstanque(new Estanque());
        mazda.setConductor(pato);
        mazda.setRuedas(ruedasMaz);

        Rueda[] ruedasNissan = {new Rueda("pirelli", 20, 11.5),
                new Rueda("pirelli", 20, 11.5),
                new Rueda("pirelli", 20, 11.5),
                new Rueda("pirelli", 20, 11.5),
                new Rueda("pirelli", 20, 11.5)};

        Rueda[] ruedasNissan2 = {new Rueda("pirelli", 20, 11.5),
                new Rueda("pirelli", 20, 11.5),
                new Rueda("pirelli", 20, 11.5),
                new Rueda("pirelli", 20, 11.5),
                new Rueda("pirelli", 20, 11.5)};

        Persona bea = new Persona("bea", "gonzalez");
        Automovil nissan = new Automovil("Nissan", "Navara", Color.GRIS,
                new Motor(4.0, TipoMotor.DIESEL), new Estanque(50),
                bea, ruedasNissan);
        nissan.setTipo(TipoAutomovil.PICKUP);

        Persona lalo = new Persona("lalo", "mena");
        Automovil nissan2 = new Automovil("Nissan", "Navara", Color.GRIS,
                new Motor(3.5,TipoMotor.BENCINA), new Estanque(50),
        lalo, ruedasNissan);

        nissan2.setTipo(TipoAutomovil.PICKUP);
        Automovil.setColorPatente(Color.AZUL);

        Automovil auto = new Automovil();

        System.out.println(subaru.verDetalles());
        System.out.println(mazda.verDetalles());
        System.out.println(nissan.verDetalles());
        System.out.println(nissan2.verDetalles());

//        System.out.println("subaru.getConductor() = " + subaru.getConductor());
//        for (Rueda r: subaru.getRuedas()){
//            System.out.println("r = " + r.getFabricante() + ", aro: " + r.getAro() + ", ancho: " + r.getAncho());
//        }

    }
}
