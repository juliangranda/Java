import java.text.SimpleDateFormat;
import java.util.Date;

public class EjemploJavaUtilDate {
    public static void main(String[] args) {

        Date fecha = new Date();

        System.out.println("fecha = " + fecha);
        //date tiene un estandar para los formatos.

        //4 MMMM se usa para mostrar la fecha en numeros con el mes en letras.
        //SimpleDateFormat dateformat = new SimpleDateFormat("dd MMMM, yyyy");

        //dos MM es para solo mostrar la fecha en numeros.(tiene diferentes formatos)
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");

        SimpleDateFormat dateformat2 = new SimpleDateFormat("'fecha: 'yyyy.MM.dd G 'hora' HH:mm:ss Z");

        SimpleDateFormat dateformat3 = new SimpleDateFormat("dd 'de' MMMM, yyyy");
        //Nota:buscar en google  SimpleDateFormat para ver los patrones que existen
        String fechaStr = dateformat.format(fecha);
        System.out.println("fechaStr = " + fechaStr);
        fechaStr = dateformat2.format(fecha);
        System.out.println("fechaStr = " + fechaStr);
        fechaStr = dateformat3.format(fecha);
        System.out.println("fechaStr = " + fechaStr);
    }
}
