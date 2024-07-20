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
        int op = -1;
        String menu = """
                          
                                    FORO "CONVERSA360"      
                               
                           [1].Crear tema                          
                           [2].Añadir mensaje                   
                           [3].Responder a mensaje                  
                           [4].Mostrar foro  
                           [5]. Buscar en el foro
                           [6].Filtrar por autor
                           [7].Salir               
                         
                           """;

        while (true) {
            String input = JOptionPane.showInputDialog(null, menu + "\nColoca una opción válida (1-6):", "Menu de Foro", JOptionPane.QUESTION_MESSAGE);
            if (input == null) {
                // Si el usuario cancela la entrada, salir del programa
                System.exit(0);
            }
            try {
                op = Integer.parseInt(input);
                if (op >= 1 && op <= 7) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Opción fuera del rango (1-6)", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Error: Entrada no válida - No sigue el formato establecido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return op;

    }

}
