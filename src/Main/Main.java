/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Clases.*;
import Excepciones.Excepcion_EntradaIncorrecta;
import Menus.*;
import Inputs.*;
import Outputs.*;
import Utilidades.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        UIManager.put("Panel.background", Color.BLACK);
        UIManager.put("OptionPane.background", Color.black);
        // Cambiar el color del texto
        UIManager.put("OptionPane.messageForeground", Color.GREEN);
        UIManager.put("Button.background", Color.BLACK);
        UIManager.put("Button.foreground", Color.WHITE);

        int opRegistro = 0;
        AtrUsuario gestionU = new AtrUsuario();
        gestionU.descongelarusuarios(); // Cargar usuarios al inicio
        AtrUsuario.cargarContador();

  
        AtrForo foro = new AtrForo(); // Crear instancia de foro y cargar temas
        AtrUsuario usuarioActual = null;
        StringBuilder mensajex = Mensaje.mensaje();

        JOptionPane.showMessageDialog(null, mensajex);
        do {
            try {

                opRegistro = MenuRegistro.menuRegistro();
            } catch (Excepcion_EntradaIncorrecta ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

            }
            switch (opRegistro) {
                case 1 -> {
                    String user = InputLogin.pedirUsuario();
                    String password = InputLogin.pedirContra();
                    usuarioActual = gestionU.iniciarSesion(user, password);
                    if (usuarioActual != null) {
                        rueda.r();
                        LogInC.ingresandoSesion();
                        int opUsuario = 0;
                        do {
                            try {
                                opUsuario = MenuUusario.menuUsuario();
                            } catch (Excepcion_EntradaIncorrecta ex) {
                                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                            switch (opUsuario) {
                                case 1:
                                    int opF;
                                    do {

                                        opF = MenuForo.menuForo();
                                        switch (opF) {

                                            case 1:
                                                String titulo = JOptionPane
                                                        .showInputDialog("Ingrese el título del nuevo tema:");
                                                foro.crearTema(titulo);
                                                break;
                                            case 2:
                                                String tituloTema = JOptionPane
                                                        .showInputDialog("Ingrese el título del tema:");
                                                String autor = usuarioActual.getUsuario();
                                                String contenido = JOptionPane.showInputDialog("Ingrese el mensaje:");
                                                foro.aMensaje(tituloTema, autor, contenido);
                                                break;
                                            case 3:
                                                tituloTema = JOptionPane.showInputDialog("Ingrese el título del tema:");
                                                int numMensaje = Integer.parseInt(JOptionPane.showInputDialog(
                                                        "Ingrese el número del mensaje al que desea responder:"));
                                                autor = usuarioActual.getUsuario();
                                                contenido = JOptionPane.showInputDialog("Ingrese la respuesta:");
                                                foro.responderMensaje(tituloTema, numMensaje, autor, contenido);

                                                break;

                                            case 4:
                                                foro.mostrarForo();
                                                break;
                                            case 5:
                                                String palabraClave = JOptionPane.showInputDialog("Ingrese la palabra clave para buscar en el foro:");
                                                foro.buscarPorPalabraClave(palabraClave);
                                                break;
                                            case 6:
                                                String autorX = JOptionPane.showInputDialog("Ingrese el nombre del autor a filtrar:");
                                                boolean encontrado = false;
                                                StringBuilder mensajesAutor = new StringBuilder();

                                                for (AtrTema tema : foro.getTemas()) {
                                                    for (AtrMensaje mensaje : tema.getMensajes()) {
                                                        // Verificar el mensaje principal
                                                        if (mensaje.getAutor().equalsIgnoreCase(autorX)) {
                                                            mensajesAutor.append(mensaje.toString()).append("\n");
                                                            encontrado = true;
                                                        }
                                                        // Verificar las respuestas del mensaje principal
                                                        for (AtrMensaje respuesta : mensaje.getRespuestas()) {
                                                            if (respuesta.getAutor().equalsIgnoreCase(autorX)) {
                                                                mensajesAutor.append(respuesta.toString()).append("\n");
                                                                encontrado = true;
                                                            }
                                                        }
                                                    }
                                                }

                                                if (encontrado) {
                                                    String mensajesFormateados = limpiarFormatoConsola(mensajesAutor.toString());
                                                    JOptionPane.showMessageDialog(null, mensajesFormateados, "Mensajes del Autor: " + autorX, JOptionPane.INFORMATION_MESSAGE);
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "No se encontraron mensajes del autor: " + autorX, "Error", JOptionPane.ERROR_MESSAGE);
                                                }
                                                break;
                                            case 7:
                                                rueda.r();
                                                LogOut.cerrarSesion();
                                                usuarioActual = null;
                                                break;
                                        }

                                    } while (opF != 5 && usuarioActual != null);
                                    break;
                                
                                case 2:
                                    JOptionPane.showMessageDialog(null, "Nombres: " + usuarioActual.getNombres() + "\n"
                                            + "Usuario: " + usuarioActual.getUsuario() + "\n" + "Contraseña: " + usuarioActual.getContra(), "Datos de usuario", JOptionPane.INFORMATION_MESSAGE);
                                    break;
                                case 3:
                                    rueda.r();
                                    LogOut.cerrarSesion();
                                    break;

                            }
                        } while (opUsuario != 3 && usuarioActual != null);
                    } else {
                        rueda.r();
                        JOptionPane.showMessageDialog(null, "Inicio de sesión fallido. Credenciales incorrectas", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
                case 2 -> {
                    int opAdmin = 0;
                    AtrAdministrador admin = new AtrAdministrador();
                    String adminUser = InputLogin.pedirUsuario();
                    String adminPassword = InputLogin.pedirContra();
                    if (admin.login(adminUser, adminPassword)) {
                        rueda.r();
                        LogInC.ingresandoSesion();
                    } else {
                        //rueda.r();

                        JOptionPane.showMessageDialog(null, "Inicio de sesión fallido.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        continue;
                    }
                    do {
                        try {
                            opAdmin = MenuAdministracion.menuAdmin();
                        } catch (Excepcion_EntradaIncorrecta ex) {
                            System.out.println(ex.getMessage());
                        }
                        switch (opAdmin) {
                            case 1:
                                if (gestionU.usuarios.isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "No hay usuarios registrados, hasta el momento",
                                            "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                                    break;
                                }
                                int opOpcion;
                                do {
                                    opOpcion = gestionU.mostrarArray();
                                    switch (opOpcion) {
                                        case 0: // Desactivar Usuario
                                            String userx = JOptionPane
                                                    .showInputDialog("Ingrese el nombre del usuario:");
                                            if (admin.DesactivarUsuario(userx, gestionU.usuarios)) {
                                                mUserDesactivo.msgDesUser();
                                                gestionU.congelarUsuarios();
                                            } else {
                                                mUsuarioNoEncontrado.notFoundUser();
                                            }
                                            break;
                                        case 1: // Reactivar Usuario
                                            String userToReactivate = JOptionPane
                                                    .showInputDialog("Ingrese el nombre del usuario:");
                                            if (admin.ActivarUsuario(userToReactivate, gestionU.usuarios)) {
                                                mUserActivo.msgActUuser();
                                                gestionU.congelarUsuarios();
                                            } else {
                                                mUsuarioNoEncontrado.notFoundUser();
                                            }
                                            break;
                                        case 2: // Eliminar Usuario
                                            String userE = JOptionPane
                                                    .showInputDialog("Ingrese el nombre del usuario:");
                                            if (admin.EliminarUsuario(userE, gestionU.usuarios)) {
                                                mUsuarioElim.msgUserDelete();
                                                gestionU.congelarUsuarios();
                                            } else {
                                                mUsuarioNoEncontrado.notFoundUser();
                                            }
                                            break;
                                    }
                                } while (opOpcion != 3);
                                break;
                            
                            case 2:
                                StringBuilder temasMensaje = new StringBuilder("Temas creados:\n");
                                for (AtrTema tema : foro.getTemas()) {
                                    temasMensaje.append(tema.getTitulo()).append("\n");
                                }
                                JOptionPane.showMessageDialog(null, temasMensaje.toString(), "Temas", JOptionPane.INFORMATION_MESSAGE);

                                break;
                            case 3:
                                StringBuilder mensajesMensaje = new StringBuilder("Mensajes:\n");
                                for (AtrTema tema : foro.getTemas()) {
                                    mensajesMensaje.append("Tema: ").append(tema.getTitulo()).append("\n");
                                    for (AtrMensaje mensaje : tema.getMensajes()) {
                                        mensajesMensaje.append(mensaje.toString()).append("\n");
                                    }
                                }
                                mostrarMensajesEnPaginas(mensajesMensaje.toString(), "Mensajes");
                                break;
                            case 4:
                                // Solicitar fechas al usuario
                                String fechaInicioStr = JOptionPane.showInputDialog("Ingrese la fecha de inicio (YYYY-MM-DD):");
                                String fechaFinStr = JOptionPane.showInputDialog("Ingrese la fecha de fin (YYYY-MM-DD):");

                                // Convertir las fechas ingresadas por el usuario a objetos LocalDate
                                LocalDate fechaInicio = LocalDate.parse(fechaInicioStr);
                                LocalDate fechaFin = LocalDate.parse(fechaFinStr);

                                // Validar que la fecha de fin sea posterior a la fecha de inicio
                                if (fechaFin.isBefore(fechaInicio)) {
                                    JOptionPane.showMessageDialog(null, "La fecha de fin debe ser posterior a la fecha de inicio.", "Error", JOptionPane.ERROR_MESSAGE);
                                    break;
                                }

                                // Filtrar mensajes por fecha
                                StringBuilder mensajesFiltrados = new StringBuilder();
                                boolean encontradoFecha = false;
                                for (AtrTema tema : foro.getTemas()) {
                                    for (AtrMensaje mensaje : tema.getMensajes()) {
                                        LocalDateTime fechaMensaje = LocalDateTime.parse(mensaje.getFechaHora(), AtrMensaje.formatter); // Accede a formatter como AtrMensaje.formatter
                                        LocalDate fechaMensajeLocalDate = fechaMensaje.toLocalDate();
                                        if (!fechaMensajeLocalDate.isBefore(fechaInicio) && !fechaMensajeLocalDate.isAfter(fechaFin)) {
                                            mensajesFiltrados.append(mensaje.toString()).append("\n");
                                            encontradoFecha = true;
                                        }
                                    }
                                }
                                // Mostrar resultados en JOptionPane
                                if (encontradoFecha) {
                                    String mensajesFormateados = limpiarFormatoConsola(mensajesFiltrados.toString());
                                    JOptionPane.showMessageDialog(null, "<html><pre>" + mensajesFormateados + "</pre></html>", "Mensajes entre " + fechaInicioStr + " y " + fechaFinStr, JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(null, "No se encontraron mensajes entre " + fechaInicioStr + " y " + fechaFinStr, "Error", JOptionPane.ERROR_MESSAGE);
                                }
                                break;

                            case 5:
                                rueda.r();
                                LogOut.cerrarSesion();
                        }
                    } while (opAdmin != 5);
                }

                case 3 ->
                    formsRegistro.registrarUsuario(gestionU);
             
                case 4 ->
                    Exit.exit();
            }
        } while (opRegistro != 4);
    } // Función para limpiar el formato de consola

    private static String limpiarFormatoConsola(String texto) {
        // Eliminar caracteres de escape y códigos de color ANSI
        texto = texto.replaceAll("\u001B\\[[;\\d]*m", "");
        // Otros ajustes necesarios
        // Puedes realizar otras operaciones de limpieza según sea necesario
        return texto;
    }

    private static void mostrarMensajesEnPaginas(String contenido, String titulo) {
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
