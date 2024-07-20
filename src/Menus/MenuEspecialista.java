/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menus;

import Excepciones.Excepcion_EntradaIncorrecta;
import javax.swing.JOptionPane;

/**
 *
 * @author ALE
 */
public class MenuEspecialista {

    public static int menuEspecialista() throws Excepcion_EntradaIncorrecta {
        int op = -1;
        String menu = """
                                                
                      MENU DE ESPECIALISTA      
                                               
                      [1].Ir al foro           
                      [2].Ver Notificaciones   
                      [3].Mi perfil          
                      [4].Cerrar Sesión       
    
                      
                      """;

        while (true) {
            String input = JOptionPane.showInputDialog(null, menu + "\nIngresa una opción válida (1-4):", "Menu de Especialista", JOptionPane.QUESTION_MESSAGE);
            if (input == null) {
                System.exit(0); // Si el usuario cancela, salir del programa
            }
            try {
                op = Integer.parseInt(input);
                if (op >= 1 && op <= 4) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "El valor no está en el rango (1-4)", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Error: Entrada no válida - No sigue el formato establecido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return op;

    }

}
