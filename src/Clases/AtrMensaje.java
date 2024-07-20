package Clases;



import javax.swing.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;

public class AtrMensaje  implements Serializable  {


    private static final long serialVersionUID = 1L;
    private String autor;
    private String contenido;
    private List<AtrMensaje> respuestas;
    private LocalDateTime fechaHora;
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    private static final int ANCHO_MAXIMO = 100; // Ancho máximo deseado

    public AtrMensaje(String autor, String contenido) {
        this.autor = autor;
        this.contenido = contenido;
        this.respuestas = new ArrayList<>();
        this.fechaHora = LocalDateTime.now();
    }

    public String getFechaHora() {
        return fechaHora.format(formatter);
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getAutor() {
        return autor;
    }

    public String getContenido() {
        return contenido;
    }

    public void addRespuesta(AtrMensaje respuesta) {
        respuestas.add(respuesta);
    }

    public List<AtrMensaje> getRespuestas() {
        return respuestas;
    }

    final String ANSI_RESET = "\u001B[0m";

    public String toString() {

        final String ANSI_PURPLE = "\u001B[35m";

        final String ANSI_BLUE = "\u001B[34m";
        StringBuilder sb = new StringBuilder();


        sb.append("Mensaje\n");
        sb.append(ANSI_PURPLE).append(getFechaHora()).append(" | @").append(autor).append("\n")
                .append(ajustarTexto(contenido, ANSI_PURPLE)).append(ANSI_RESET).append("\n");
        
        sb.append("Respuestas:\n");
        for (AtrMensaje respuesta : respuestas) {
            sb.append(ANSI_BLUE).append(respuesta.getFechaHora()).append(" | @").append(respuesta.getAutor())
                    .append("\n").append(ANSI_RESET).append(ajustarTexto(respuesta.getContenido(), ANSI_BLUE))
                    .append("\n\n");
        }

        return sb.toString();
    }

    private String ajustarTexto(String texto, String color) {
        StringBuilder sb = new StringBuilder();
        int indiceInicio = 0;
        while (indiceInicio < texto.length()) {
            int indiceFin = Math.min(indiceInicio + ANCHO_MAXIMO, texto.length());
            sb.append(color).append(texto.substring(indiceInicio, indiceFin)).append(ANSI_RESET);
            if (indiceFin < texto.length()) {
                sb.append("\n"); // Agregar salto de línea si hay más texto por ajustar
            }
            indiceInicio = indiceFin;
        }
        return sb.toString();
    }
}
