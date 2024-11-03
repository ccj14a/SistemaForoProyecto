/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menus;


import Excepciones.*;
import javax.swing.JOptionPane;

public class MenuRegistro {


    public static int menuRegistro() throws Excepcion_EntradaIncorrecta {
        int op = -1;
        String menu = """
                          
                      BIENVENDIDO A "CONVERSA360"      
                               
                      *Ingresar como:                           
                           [1].Usuario                                           
                           [2].Administrador                    
                      *No tienes una cuenta?.Crear:             
                           [3].Como usuario                    
                           [4].Como especialista                
                           [5].Cerrar Aplicación                
                         
                           """;

        while (true) {
            String input = JOptionPane.showInputDialog(null, menu + "\nColoca una opción válida (1-5):", "CONVERSA360", JOptionPane.QUESTION_MESSAGE);
            if (input == null) {
                // Si el usuario cancela la entrada, salir del programa
                System.exit(0);
            }
            try {
                op = Integer.parseInt(input);
                if (op >= 1 && op <= 5) {
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
