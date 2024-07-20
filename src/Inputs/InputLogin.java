package Inputs;

import Clases.AtrSuperUsuario;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class InputLogin {

    public static boolean iniciarSesion(AtrSuperUsuario usuario) {
        String user = JOptionPane.showInputDialog(null, "Usuario:", "Iniciar Sesión", JOptionPane.QUESTION_MESSAGE);
        if (user == null) {
            return false; // Cancelado por el usuario
        }

        JPasswordField passwordField = new JPasswordField();
        int option = JOptionPane.showConfirmDialog(null, passwordField, "Contraseña:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option != JOptionPane.OK_OPTION) {
            return false; // Cancelado por el usuario
        }

        String pass = new String(passwordField.getPassword());
        return usuario.login(user, pass);
    }

    public static String pedirUsuario() {
        return JOptionPane.showInputDialog("Ingrese su nombre de usuario:");
    }

    public static String pedirContra() {
        JPasswordField passwordField = new JPasswordField();
        int option = JOptionPane.showConfirmDialog(null, passwordField, "Ingrese su contraseña:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            return new String(passwordField.getPassword());
        } else {
            return null; // Cancelado por el usuario
        }
    }
}
