/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menus;

import javax.swing.JOptionPane;

/**
 *
 * @author ALE
 */
public class MenuForo {

    public static int menuForo() {
        String menu = """
            FORO "CONVERSA360"
            [1]. Crear tema
            [2]. Añadir mensaje
            [3]. Responder a mensaje
            [4]. Mostrar foro
            [5]. Buscar en el foro
            [6]. Filtrar por autor
            [7]. Salir
            """;

        String[] opciones = {"1", "2", "3", "4", "5", "6", "7"}; // Opciones numeradas

        int seleccion = JOptionPane.showOptionDialog(null, menu, "Menu de Foro",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        // Verificar si el usuario canceló
        if (seleccion == JOptionPane.CLOSED_OPTION) {
            System.exit(0); // Salir si se cierra el diálogo
        }

        // Devolver la opción seleccionada (sumando 1 para que sea igual a la opción del menú)
        return seleccion + 1; // Convertir el índice a opción (1-7)

    }

}
