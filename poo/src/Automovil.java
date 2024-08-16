public class Automovil {

    //atributos
    private String fabricante;
    private String modelo;
    private String color;
    private double cilindrada;
    private int capacidadEstanque = 40;

    //metodos

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }

    public int getCapacidadEstanque() {
        return capacidadEstanque;
    }

    public void setCapacidadEstanque(int capacidadEstanque) {
        this.capacidadEstanque = capacidadEstanque;
    }

    public void verDetalles(){
        //this hace referencia a la misma clase/instancia.
        System.out.println("auto.fabricante = " + this.getFabricante());
        System.out.println("auto.modelo = " + this.getModelo());
        System.out.println("auto.color = " + this.getColor());
        System.out.println("auto.cilindrada = " + this.getCilindrada());
        System.out.println();
    }

    public String acelerar(int rpm){
        return "el auto " + this.fabricante + " acelerando a " + rpm + "rpm";
    }
    public String frenar(){

        return this.fabricante + " " + this.modelo + " frenando!";
    }
    public String acelerarFrenar(int rpm) {
        String acelerar = this.acelerar(rpm);
        String frenar = this.frenar();
        return acelerar + "\n" + frenar;
    }
    public float calcularConsumo(int km, float porcentajeBencina) {
        return km / (capacidadEstanque * porcentajeBencina);
    }

    //sobreCarga de metodos:
    //mismo tipo de nombre pero diferente tipo primitivos en los parametros.
    public float calcularConsumo(int km, int porcentajeBencina) {
        return km / (capacidadEstanque * (porcentajeBencina/100f));
    }

}
