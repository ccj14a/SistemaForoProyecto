/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import javax.swing.JOptionPane;

public class LogOut {

    public static void cerrarSesion() {
        
        for (int i = 0; i < 1; i++) {
            try {
                // Espera 500 milisegundos (0.5 segundos)
                Thread.sleep(100);
                // Imprime un punto suspensivo
                //System.out.print(".");
            } catch (InterruptedException e) {
                // Si ocurre una interrupción, imprime el stack trace
                e.printStackTrace();
            }
        }
        
       
        JOptionPane.showMessageDialog(null, "Sesión cerrada.");
    }

}
