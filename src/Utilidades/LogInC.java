package Utilidades;

import javax.swing.JOptionPane;


public class LogInC {
    public static void ingresandoSesion() {
       
        
        // Pausa la ejecución del programa por intervalos y muestra puntos suspensivos.
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
        
        JOptionPane.showMessageDialog(null, "Credenciales correctas. Sesion iniciada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }
}
