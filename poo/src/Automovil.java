public class Automovil {

    //atributos
    String fabricante;
    String modelo;
    String color;
    double cilindrada;

    //metodos
    public void detalles(){
        //this hace referencia a la misma clase/instancia.
        System.out.println("auto.fabricante = " + this.fabricante);
        System.out.println("auto.modelo = " + this.modelo);
        System.out.println("auto.color = " + this.color);
        System.out.println("auto.cilindrada = " + this.cilindrada);
        System.out.println();
    }

}
