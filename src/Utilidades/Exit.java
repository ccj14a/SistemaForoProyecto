/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author ALE
 */
public class Exit {

    public static void exit() {
        // Mostrar GIF de carga en un JFrame
        ImageIcon loadingIcon = new ImageIcon("src/img/carga2.gif");

        // Crear un JLabel con el GIF
        JLabel label = new JLabel("", loadingIcon, JLabel.CENTER);

        // Crear un JFrame
        JFrame frame = new JFrame("Cerrando aplicación");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(600, 120); // Tamaño del JFrame
        frame.setLayout(new BorderLayout());
        frame.add(label, BorderLayout.CENTER);
        frame.setUndecorated(true); // Quitar los bordes y botones del JFrame
        frame.setLocationRelativeTo(null); // Centrar el JFrame en la pantalla
        frame.setVisible(true);
        
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                frame.dispose();
                JOptionPane.showMessageDialog(null, "Aplicación cerrada con éxito.", "Cerrar sesión", JOptionPane.INFORMATION_MESSAGE);
                timer.cancel(); // Cancelar el Timer después de ejecutar la tarea
            }
        }, 2500);

    }

}
