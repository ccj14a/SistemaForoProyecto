/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menus;

import Excepciones.Excepcion_EntradaIncorrecta;
import javax.swing.JOptionPane;

public class MenuAdministracion {

    public static int menuAdmin() throws Excepcion_EntradaIncorrecta {
        String menu = """
            MENU DE ADMINISTRACIÓN

            [1]. Administrar Usuarios
            [2]. Temas creados
            [3]. Administrar Mensajes
            [4]. Filtrar foro
            [5]. Cerrar Sesión
            """;

        String[] opciones = {"1", "2", "3", "4", "5"}; // Opciones numeradas

        int seleccion = JOptionPane.showOptionDialog(null, menu, "Menu de Administración",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        // Verificar si el usuario canceló
        if (seleccion == JOptionPane.CLOSED_OPTION) {
            System.exit(0); // Salir si se cierra el diálogo
        }

        // Devolver la opción seleccionada (sumando 1 para que sea igual a la opción del menú)
        return seleccion + 1; // Convertir el índice a opción (1-5)

    }
}
