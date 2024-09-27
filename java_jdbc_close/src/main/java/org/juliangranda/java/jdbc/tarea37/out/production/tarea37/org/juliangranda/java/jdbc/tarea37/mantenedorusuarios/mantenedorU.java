package org.juliangranda.java.jdbc.tarea37.out.production.tarea37.org.juliangranda.java.jdbc.tarea37.mantenedorusuarios;
import java.awt.Component;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import org.juliangranda.java.jdbc.tarea37.mantenedorusuarios.modelo.Usuario;
import org.juliangranda.java.jdbc.tarea37.mantenedorusuarios.repositorio.IRepositorio;
import org.juliangranda.java.jdbc.tarea37.mantenedorusuarios.repositorio.UsuarioRepositorioImpl;

public class mantenedorU {

    public mantenedorU() {
    }

    public static void main(String[] args) {

        IRepositorio<Usuario> repositorio = new UsuarioRepositorioImpl();
        int opcionIndice = 0;
        Map<String, Integer> operaciones = new HashMap();
        operaciones.put("Actualizar", 1);
        operaciones.put("Eliminar", 2);
        operaciones.put("Agregar", 3);
        operaciones.put("Listar", 4);
        operaciones.put("Salir", 5);
        Object[] opArreglo = operaciones.keySet().toArray();

        do {
            Object opcion = JOptionPane.showInputDialog((Component) null, "Seleccione una Operación", "Mantenedor de Usuarios", 1, (Icon) null, opArreglo, opArreglo[0]);
            if (opcion == null) {
                JOptionPane.showMessageDialog((Component) null, "Debe seleccionar una operación");
            } else {
                opcionIndice = (Integer) operaciones.get(opcion.toString());
                switch (opcionIndice) {
                    case 1:
                        System.out.println("Opcion Actualizar");
                        System.out.println(repositorio.porId(1L));
                        break;
                    case 2:
                        System.out.println("Opcion Eliminar");
                        break;
                    case 3:
                        System.out.println("Opcion Agregar");
                        Usuario usuario = new Usuario();
                        usuario.setUsername("Julian");
                        usuario.setPassword("admin");
                        usuario.setEmail("juliangranda@hotmail.com");
                        repositorio.guardar(usuario);
                        System.out.println("Usuario Guardado con Exito");
                        break;
                    case 4:
                        System.out.println("Opcion Listar");
                        List var10000 = repositorio.listar();
                        PrintStream var10001 = System.out;
                        Objects.requireNonNull(var10001);
                        var10000.forEach(var10001::println);
                        break;
                    case 5:
                        System.out.println("Opcion salir");
                }
            }
        } while (opcionIndice != 5);

    }
}
