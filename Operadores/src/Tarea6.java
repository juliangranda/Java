import javax.swing.*;

public class Tarea6 {
    public static void main(String[] args) {

        String persona1 = JOptionPane.showInputDialog("Ingrese su nombre completo");
        String persona2 = JOptionPane.showInputDialog("Ingrese su nombre completo");
        String persona3 = JOptionPane.showInputDialog("Ingrese su nombre completo");
        String max = (persona1.split(" ")[0].length() < persona2.split(" ")[0].length())
                ? persona2:persona1;
        max = (persona2.split(" ")[0].length() < persona3.split(" ")[0].length())
                ? persona3:persona2;
        System.out.println(max + " es el nombre mas largo.");

    }
}
