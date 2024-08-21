public class PersonasDeUnaCompañia {
    public static void main(String[] args) {
        Persona persona1 = new Persona("julian","gomez","1","calle42 por carrera81");
        //System.out.println(persona1.toString());
        Empleado empleado1 = new Empleado("david","granda","2","carrera 84 laureles",200.25);
        System.out.println(empleado1.toString());
        System.out.println("----------------------------------");

        Empleado empleado2 = new Empleado("david","granda","2","carrera 84 laureles",200.25);
        System.out.println(empleado2.toString());
        System.out.println("---------------------------------");

        Cliente cliente1 = new Cliente("juan","gomez","5","Estadio");
        System.out.println(cliente1.toString());
        System.out.println("------------------------------------");

        Gerente gerente1 = new Gerente("gloria","gomez","3","larureles",5000,10000);
        gerente1.aumentarRemuneracion(15);
        gerente1.setPresupuesto(15000);
        System.out.println(gerente1.toString());

    }
}
