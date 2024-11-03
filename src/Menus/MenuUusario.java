/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menus;

import Excepciones.Excepcion_EntradaIncorrecta;
import javax.swing.JOptionPane;

public class MenuUusario {

    public static int menuUsuario() throws Excepcion_EntradaIncorrecta {
        String menu = """
            MENU DE USUARIO
            [1]. Ir al foro
            [2]. Mi perfil
            [3]. Cerrar Sesión
            """;

        String[] opciones = {"1", "2", "3"}; // Opciones numeradas

        int seleccion = JOptionPane.showOptionDialog(null, menu, "Menu de Usuario",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        // Verificar si el usuario canceló
        if (seleccion == JOptionPane.CLOSED_OPTION) {
            System.exit(0); // Salir si se cierra el diálogo
        }

        // Devolver la opción seleccionada (sumando 1 para que sea igual a la opción del menú)
        return seleccion + 1; // Convertir el índice a opción (1-3)

    }

}
