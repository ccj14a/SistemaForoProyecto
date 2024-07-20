/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inputs;

import Clases.*;
import javax.swing.JOptionPane;

public class formsRegistro {

    public static void registrarUsuario(AtrUsuario user) {
        String nombre = JOptionPane.showInputDialog(null, "Nombres*", "Registro de Usuario",
                JOptionPane.QUESTION_MESSAGE);
        if (nombre == null) {
            // Si el usuario presiona "Cancelar", redirige al menú principal
            return;
        } else if (nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nombre no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
            registrarUsuario(user); // Vuelve a solicitar el nombre
            return;
        }

        String usuario = JOptionPane.showInputDialog(null, "Usuario*", "Registro de Usuario",
                JOptionPane.QUESTION_MESSAGE);
        if (usuario == null) {
            // Si el usuario presiona "Cancelar", redirige al menú principal
            return;
        } else if (usuario.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Usuario no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
            registrarUsuario(user); // Vuelve a solicitar el usuario
            return;
        }

        String contraseña = JOptionPane.showInputDialog(null, "Contraseña*", "Registro de Usuario",
                JOptionPane.QUESTION_MESSAGE);
        if (contraseña == null) {
            // Si el usuario presiona "Cancelar", redirige al menú principal
            return;
        } else if (contraseña.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Contraseña no puede estar vacía", "Error", JOptionPane.ERROR_MESSAGE);
            registrarUsuario(user); // Vuelve a solicitar la contraseña
            return;
        }

        AtrUsuario nuevoUsuario = new AtrUsuario(nombre, usuario, contraseña);
        if (!nuevoUsuario.guardarDatos(nuevoUsuario.getUsuario())) {
            user.guardarArray(nuevoUsuario);
        }

    }

    public static void registrarEspecialista(AtrEspecialistas espe) {
        String nombre = JOptionPane.showInputDialog(null, "Nombres*", "Registro de Especialista",
                JOptionPane.QUESTION_MESSAGE);
        if (nombre == null || nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nombre no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String usuario = JOptionPane.showInputDialog(null, "Usuario*", "Registro de Usuario",
                JOptionPane.QUESTION_MESSAGE);
        if (usuario == null || usuario.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Usuario no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String contraseña = JOptionPane.showInputDialog(null, "Contraseña*", "Registro de Usuario",
                JOptionPane.QUESTION_MESSAGE);
        if (contraseña == null || contraseña.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Contraseña no puede estar vacía", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String especialidad = JOptionPane.showInputDialog(null, "Especialidad*", "Registro de Usuario",
                JOptionPane.QUESTION_MESSAGE);
        if (especialidad == null || especialidad.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Especialidad no puede estar vacía", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String direccion = JOptionPane.showInputDialog(null, "Direccion*", "Registro de Usuario",
                JOptionPane.QUESTION_MESSAGE);
        if (direccion == null || direccion.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Direccion no puede estar vacía", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String telefono = JOptionPane.showInputDialog(null, "Telefono*", "Registro de Usuario",
                JOptionPane.QUESTION_MESSAGE);
        if (telefono == null || telefono.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Telefono no puede estar vacía", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String dni = JOptionPane.showInputDialog(null, "dni*", "Registro de Usuario", JOptionPane.QUESTION_MESSAGE);
        if (dni == null || dni.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "dni no puede estar vacía", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        AtrEspecialistas nuevoEspecialista = new AtrEspecialistas(direccion,telefono,dni,nombre,usuario,contraseña,especialidad);
        if (!nuevoEspecialista.guardarDatos(nuevoEspecialista.getUsuario())) {
            espe.guardarArray(nuevoEspecialista);
        }

    }
}
