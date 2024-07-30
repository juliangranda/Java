import java.util.Scanner;

public class DetalleDeFactura {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("nombre de la factura: ");
        String nombreFactura = scanner.nextLine();
        System.out.println("Precio energia: ");
        double energia = scanner.nextDouble();
        System.out.println("Precio agua:");
        double agua = scanner.nextDouble();

        double totalBruto = energia+agua;
        double impuesto = totalBruto*0.19;
        double total = totalBruto + impuesto;

        String detalle = "La factura " + nombreFactura
                + " tiene un total bruto de " + totalBruto
                + ", con un impuesto de " + impuesto
                + " y el monto despues de impuesto es de " + total;
        System.out.println("detalle = " + detalle);
    }
}
