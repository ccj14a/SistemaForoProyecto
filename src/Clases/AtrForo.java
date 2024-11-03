package Clases;

import java.awt.Dimension;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class AtrForo implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<AtrTema> temas;

    public AtrForo() {
        this.temas = new ArrayList<>();
        cargarTemas(); // Cargar los temas al inicializar
    }

    public void crearTema(String titulo) {
        temas.add(new AtrTema(titulo));
        guardarTemas(); // Guardar los temas cada vez que se crea un nuevo tema
    }
    public List<AtrTema> getTemas() {
        return temas;
    }

    public void aMensaje(String tituloTema, String autor, String contenido) {
        for (AtrTema tema : temas) {
            if (tema.getTitulo().equals(tituloTema)) {
                tema.addMensaje(new AtrMensaje(autor, contenido));
                guardarTemas(); // Guardar los temas cada vez que se añade un mensaje
                return;
            }
        }
        System.out.println("Tema no encontrado: " + tituloTema);
    }

    public void responderMensaje(String tituloTema, int numMensaje, String autor, String contenido) {
        for (AtrTema tema : temas) {
            if (tema.getTitulo().equals(tituloTema)) {
                if (numMensaje > 0 && numMensaje <= tema.getMensajes().size()) {
                    AtrMensaje mensajeOriginal = tema.getMensajes().get(numMensaje - 1);
                    mensajeOriginal.addRespuesta(new AtrMensaje(autor, contenido));
                    guardarTemas(); // Guardar los temas cada vez que se responde a un mensaje
                } else {
                    System.out.println("Número de mensaje no válido.");
                }
                return;
            }
        }
        System.out.println("Tema no encontrado: " + tituloTema);
    }

    public void mostrarForo() {
        for (AtrTema tema : temas) {
            System.out.println(tema);
        }
    }

    public void guardarTemas() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("temas.ser"))) {
            out.writeObject(temas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarTemas() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("temas.ser"))) {
            temas = (ArrayList<AtrTema>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            temas = new ArrayList<>(); // Si no se encuentra el archivo, iniciar con una lista vacía
        }
    }
    public void buscarPorPalabraClave(String palabraClave) {
        StringBuilder resultados = new StringBuilder();
        boolean encontrado = false;

        // Asegúrate de que la palabra clave no sea nula
        if (palabraClave == null || palabraClave.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar una palabra clave.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String palabraClaveLower = palabraClave.toLowerCase();
        String palabraClaveHtml = "<b><font color='red'>" + palabraClave + "</font></b>";

        for (AtrTema tema : temas) {
            for (AtrMensaje mensaje : tema.getMensajes()) {
                String mensajeContenido = mensaje.getContenido().toLowerCase();
                if (mensajeContenido.contains(palabraClaveLower)) {
                    resultados.append("Tema: ").append(tema.getTitulo()).append("<br>")
                            .append(resaltarPalabraClave(mensaje.getContenido(), palabraClave)).append("<br><br>");
                    encontrado = true;
                }
                for (AtrMensaje respuesta : mensaje.getRespuestas()) {
                    String respuestaContenido = respuesta.getContenido().toLowerCase();
                    if (respuestaContenido.contains(palabraClaveLower)) {
                        resultados.append("Tema: ").append(tema.getTitulo()).append("<br>")
                                .append("Comentarios: ").append(resaltarPalabraClave(respuesta.getContenido(), palabraClave)).append("<br><br>");
                        encontrado = true;
                    }
                }
            }
        }

        if (encontrado) {
            mostrarMensajesEnPaginasF(resultados.toString(), "Resultados de la búsqueda");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron resultados para la palabra clave: " + palabraClave, "Resultados de la búsqueda", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private String resaltarPalabraClave(String texto, String palabraClave) {
        return texto.replaceAll("(?i)" + palabraClave, "<b><font color='red'>" + palabraClave + "</font></b>");
    }
    private void mostrarMensajesEnPaginasF(String resultados, String titulo) {
        // Aquí se utiliza un JTextPane para mostrar los resultados con formato HTML
        JTextPane textPane = new JTextPane();
        textPane.setContentType("text/html");
        textPane.setText("<html>" + resultados + "</html>");
        textPane.setEditable(false);

        // Crear un JScrollPane y ajustar su tamaño preferido
        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setPreferredSize(new Dimension(500, 400));  // Ajusta el tamaño según sea necesario

        JOptionPane.showMessageDialog(null, scrollPane, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
     private void mostrarMensajesEnPaginas(String contenido, String titulo) {
        // Elimina los caracteres de escape y códigos de color
        contenido = contenido.replaceAll("\u001B\\[[;\\d]*m", "");

        final int TAMANO_MAXIMO = 1000; // Ajusta este valor según sea necesario
        int inicio = 0;
        int totalLength = contenido.length();

        while (inicio < totalLength) {
            int fin = Math.min(inicio + TAMANO_MAXIMO, totalLength);
            String parte = contenido.substring(inicio, fin);

            JTextArea textArea = new JTextArea(parte);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            textArea.setCaretPosition(0);  // Para asegurarse de que el texto se muestre desde el principio
            textArea.setEditable(false);

            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(600, 300)); // Ajusta el tamaño del JScrollPane según sea necesario

            Object[] options = {"Anterior", "Siguiente", "Cerrar"};
            int opcion = JOptionPane.showOptionDialog(null, scrollPane, titulo,
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);

            if (opcion == JOptionPane.CLOSED_OPTION || opcion == 2) {
                break;
            } else if (opcion == 0 && inicio > 0) { // Anterior
                inicio = Math.max(0, inicio - TAMANO_MAXIMO);
            } else if (opcion == 1 && fin < totalLength) { // Siguiente
                inicio = fin;
            } else {
                break;
            }
        }
    }
}
