public class Cliente extends Persona{
    private int clienteID;
    private static int contadorID;

    public Cliente(String nombre, String apellido, String numeroFiscal, String direccion) {
        super(nombre, apellido, numeroFiscal, direccion);
        this.clienteID = ++contadorID;
    }

    public int getClienteID() {
        return clienteID;
    }

    @Override
    public String toString() {
        return  " clienteID=" + clienteID +
                "\n"+ super.toString();

    }
}
