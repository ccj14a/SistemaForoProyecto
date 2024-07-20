package Clases;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AtrTema implements Serializable {
    private static final long serialVersionUID = 1L;
    private String titulo;
    private List<AtrMensaje> mensajes;

    public AtrTema(String titulo) {
        this.titulo = titulo;
        this.mensajes = new ArrayList<>();
    }

    public String getTitulo() {


        return titulo;
    }
    

    public void addMensaje(AtrMensaje mensaje) {
        mensajes.add(mensaje);
    }

    public List<AtrMensaje> getMensajes() {
        return mensajes;
    }

    @Override
    public String toString() {
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RESET = "\u001B[0m";
        StringBuilder sb = new StringBuilder();
        sb.append(ANSI_GREEN).append("Tema: ").append(titulo).append(ANSI_RESET).append("\n");
        int index = 1;
        for (AtrMensaje mensaje : mensajes) {
            sb.append(index++).append(". ").append(mensaje).append("\n");
        }

        System.out.println("_______________________________________________________________________________________________________________");
        return sb.toString();
    }
}
