public class Automovil {

    //atributos
    String fabricante;
    String modelo;
    String color;
    double cilindrada;
    int capacidadEstanque = 40;

    //metodos
    public void verDetalles(){
        //this hace referencia a la misma clase/instancia.
        System.out.println("auto.fabricante = " + this.fabricante);
        System.out.println("auto.modelo = " + this.modelo);
        System.out.println("auto.color = " + this.color);
        System.out.println("auto.cilindrada = " + this.cilindrada);
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
