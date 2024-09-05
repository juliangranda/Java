import java.util.Date;

public class Vuelo {
    private String nombre;
    private String origen;
    private String destino;
    private Date fechaLLegada;
    private int numPasajeros;

    public Vuelo(String nombre, String origen, String destino, Date fechaLLegada, int numPasajeros) {
        this.nombre = nombre;
        this.origen = origen;
        this.destino = destino;
        this.fechaLLegada = fechaLLegada;
        this.numPasajeros = numPasajeros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFechaLLegada() {
        return fechaLLegada;
    }

    public void setFechaLLegada(Date fechaLLegada) {
        this.fechaLLegada = fechaLLegada;
    }

    public int getNumPasajeros() {
        return numPasajeros;
    }

    public void setNumPasajeros(int numPasajeros) {
        this.numPasajeros = numPasajeros;
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "nombre='" + nombre + '\'' +
                ", origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", fechaLLegada=" + fechaLLegada +
                ", numPasajeros=" + numPasajeros +
                '}';
    }
}
