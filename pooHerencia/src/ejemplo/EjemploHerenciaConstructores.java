package ejemplo;

import org.juliangranda.pooherencia.Alumno;
import org.juliangranda.pooherencia.AlumnoInternacional;
import org.juliangranda.pooherencia.Persona;
import org.juliangranda.pooherencia.Profesor;

public class EjemploHerenciaConstructores {
    public static void main(String[] args) {
        System.out.println("======== Creando la instancia de la clase Alumno ========");
        Alumno alumno = new Alumno("julian","Gomez",28,"ITM");

        alumno.setNotaCastellana(5.5);
        alumno.setNotaHistoria(6.3);
        alumno.setNotaMatematica(4.9);
        alumno.setEmail("julian@hotmail");

        System.out.println("======= Creando la instancia de la clase AlumnoInternacional ======= ");
        AlumnoInternacional alumnoInt = new AlumnoInternacional("Peter","Gosling","Australia");

        alumnoInt.setEdad(15);
        alumnoInt.setInstitucion("Instituto Nacional");
        alumnoInt.setNotasIdiomas(6.8);
        alumnoInt.setNotaCastellana(6.2);
        alumnoInt.setNotaHistoria(5.8);
        alumnoInt.setNotaMatematica(6.5);
        alumnoInt.setEmail("Peter@gmail.com");

        System.out.println("======= Creando la instancia de la clase de Profesor =======");
        Profesor profesor = new Profesor("luci","Perez","Matematicas");
        profesor.setEdad(40);
        profesor.setEmail("Luci@hotmail.com");

        System.out.println(" ======== - ==========================================");
        imprimir(alumno);
        imprimir(alumnoInt);
        imprimir(profesor);
    }


    public static void imprimir(Persona persona){
        System.out.println("Imprimiendo datos en común del tipo Persona:");
        System.out.println("nombre: " + persona.getNombre()
                + ", apellido: " + persona.getApellido()
                + ", edad: " + persona.getEdad()
                + ", email: " + persona.getEmail());

        if (persona instanceof Alumno) {
            System.out.println("Imprimiendo los datos del tipo Alumno:");
            System.out.println("Institución: " + ((Alumno) persona).getInstitucion());
            System.out.println("Nota matemáticas: " + ((Alumno) persona).getNotaMatematica());
            System.out.println("Nota Historia: " + ((Alumno) persona).getNotaHistoria());
            System.out.println("Nota Castellano: " + ((Alumno) persona).getNotaCastellana());

            if (persona instanceof AlumnoInternacional) {
                System.out.println("Imprimiendo los datos del tipo AlumnoInternacional:");
                System.out.println("Nota idiomas: " + ((AlumnoInternacional) persona).getNotasIdiomas());
                System.out.println("Pais: " + ((AlumnoInternacional) persona).getPais());
            }

            //downcasting
            System.out.println("============== sobre escritura promedio ===============");
            System.out.println("Promedio: " + ((Alumno) persona).calcularPromedio());
            System.out.println("============== sobre escritura promedio ===============");

        }

        if (persona instanceof Profesor) {
            System.out.println("Imprimiendo los datos del tipo Profesor:");
            System.out.println("Asignatura: " + ((Profesor) persona).getAsignatura());
        }

        System.out.println(" ========Sobre Escritura saludar=====================");
        System.out.println(persona.saludar());
        System.out.println(" ==================================================");

    }


}
