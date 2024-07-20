/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 *
 * @author ALE
 */
public class rueda {

    public static void r() {
        // Mostrar GIF de carga en un JFrame
        ImageIcon loadingIcon = new ImageIcon("src/img/carga2.gif");

        // Crear un JLabel con el GIF
        JLabel label = new JLabel("", loadingIcon, JLabel.CENTER);

        // Crear un JFrame
        JFrame frame = new JFrame("Cerrando aplicación");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(600, 100); // Tamaño del JFrame
        frame.setLayout(new BorderLayout());
        frame.add(label, BorderLayout.CENTER);
        frame.setUndecorated(true); // Quitar los bordes y botones del JFrame
        frame.setLocationRelativeTo(null); // Centrar el JFrame en la pantalla
        frame.setVisible(true);

        for (int i = 0; i < 10; i++) {
            try {

                Thread.sleep(150);

            } catch (InterruptedException e) {

                e.printStackTrace();
            }

        }
        
        frame.dispose();

    }

}
