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

  
}
