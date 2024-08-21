public class Empleado extends Persona{
    private double remuneracion;
    private int empleadoID;
    private static int contadorID;


    public Empleado(String nombre, String apellido, String numeroFiscal, String direccion, double remuneracion) {
        super(nombre, apellido, numeroFiscal, direccion);
        this.remuneracion = remuneracion;
        this.empleadoID = ++contadorID;
    }

    public void aumentarRemuneracion(int porcentaje){
       this.remuneracion += remuneracion * porcentaje/100;
    }

    public double getRemuneracion() {
        return remuneracion;
    }

    public int getEmpleadoID() {
        return empleadoID;
    }

    @Override
    public String toString() {
        return " empleadoID= " + getEmpleadoID() +
                "\n remuneracion=" + remuneracion +
                "\n" + super.toString();
    }
}
