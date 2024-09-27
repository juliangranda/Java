package org.juliangranda.java.jdbc.tarea37.mantenedorusuarios;

import org.juliangranda.java.jdbc.tarea37.mantenedorusuarios.modelo.Usuario;
import org.juliangranda.java.jdbc.tarea37.mantenedorusuarios.repositorio.IRepositorio;
import org.juliangranda.java.jdbc.tarea37.mantenedorusuarios.repositorio.UsuarioRepositorioImpl;

import javax.swing.*;
import java.util.*;

public class MantenedorUsuariosJDBC {
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
            Object opcion = JOptionPane.showInputDialog(null,
                    "Seleccione una Operación",
                    "Mantenedor de Usuarios",
                    JOptionPane.INFORMATION_MESSAGE, null, opArreglo, opArreglo[0]);

            if (opcion == null) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una operación");
            } else {
                opcionIndice = operaciones.get(opcion.toString());
                Long id;
                String username;
                String password;
                String email;

                switch (opcionIndice){
                    case 1:
                        System.out.println("Opcion Actualizar");
                        id = Long.valueOf(JOptionPane.showInputDialog(null,"Ingresar el id del usuario para actualizar"));
                        Usuario usuario = repositorio.porId(id);
                        if(usuario != null){
                            username = JOptionPane.showInputDialog("Ingrese el username",usuario.getUsername());
                            password = JOptionPane.showInputDialog("Ingrese el password",usuario.getPassword());
                            email = JOptionPane.showInputDialog("Ingese el email nuevo",usuario.getEmail());

                            usuario.setUsername(username);
                            usuario.setPassword(password);
                            usuario.setEmail(email);

                            repositorio.guardar(usuario);
                            JOptionPane.showMessageDialog(null,"Actualizar Usuario Exitosamente");
                        }
                        break;
                    case 2:
                        System.out.println("Opcion Eliminar");
                        id = Long.valueOf(JOptionPane.showInputDialog(null,"Ingrese el id del usuario a actualizar"));
                        repositorio.eliminar(id);
                        JOptionPane.showMessageDialog(null,"Usuario Eliminado Exitosamente");
                        break;
                    case 3:
                        System.out.println("Opcion Agregar");
                        username = JOptionPane.showInputDialog(null, "ingresar el username para nuevo usuario");
                        password = JOptionPane.showInputDialog(null,"Ingresar la password ");
                        email = JOptionPane.showInputDialog(null,"Ingresar el correo/email");
                        Usuario usuarioUpdate = new Usuario();
                        usuarioUpdate.setUsername(username);
                        usuarioUpdate.setPassword(password);
                        usuarioUpdate.setEmail(email);
                        repositorio.guardar(usuarioUpdate);
                        JOptionPane.showMessageDialog(null,"Usuario Agregado exitosamente");
                        break;
                    case 4:
                        System.out.println("Opcion Listar");
                        repositorio.listar().forEach(System.out::println);
                        break;
                    case 5:
                        System.out.println("Opcion salir");
                        break;
                }
            }
        } while (opcionIndice != 5);

    }
}
