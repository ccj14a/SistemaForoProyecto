/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.Serializable;

public class AtrUsuario extends AtrSuperUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    private int idUsuario;
    private static int contador = 0;
    public ArrayList<AtrUsuario> usuarios = new ArrayList<>();

    public AtrUsuario(String nombres, String usuario, String contra) {
        super(nombres, usuario, contra);
        setEstado(true);
        this.idUsuario = ++contador;
    }

    public void congelarUsuarios() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("usuarios.ser"))) {
            out.writeObject(usuarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void descongelarusuarios() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("usuarios.ser"))) {
            usuarios = (ArrayList<AtrUsuario>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            usuarios = new ArrayList<>();
        }
    }

    @Override
    public boolean guardarDatos(String user) {
        for (AtrUsuario u : usuarios) {
            if (user.equals(u.getUsuario())) {
                return true;
            }

        }
        return false;

    }

    @Override
    public boolean login(String user, String contra) {
        for (AtrUsuario u : usuarios) {
            if (u.getUsuario().equals(user) && u.getContra().equals(contra) && u.isEstado()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void guardarArray(AtrSuperUsuario u) {
        if (!(u instanceof AtrUsuario)) {
            throw new IllegalArgumentException("El objeto no es una instancia de AtrUsuario");
        }
        AtrUsuario usuario = (AtrUsuario) u;
        if (guardarDatos(u.getUsuario())) {
            JOptionPane.showMessageDialog(null, "Ese usuario ya está en uso, coloque otro", "Advertencia",
                    JOptionPane.INFORMATION_MESSAGE);

            System.out.println();
        } else {

            usuarios.add(usuario);
            congelarUsuarios();
            guardarContador();
            JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente.", "Registro Completo",
                    JOptionPane.INFORMATION_MESSAGE);

        }
    }

    @Override
    public int mostrarArray() {
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Usuarios Registrados:\n");
        for (AtrUsuario u : usuarios) {
            mensaje.append(u).append("\n");
        }
        String[] opciones = { "Desactivar Usuario", "Reactivar Usuario", "Eliminar Usuario", "Cancelar" };
        int seleccion = JOptionPane.showOptionDialog(null, mensaje.toString(), "Usuarios Registrados",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

        return seleccion;
    }

    @Override
    public String toString() {
        return "ID usuario:" + idUsuario + ", " + super.toString();
    }

    public AtrUsuario() {
        cargarContador();
    }

    // Método para guardar el contador
    public static void guardarContador() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("contador.ser"))) {
            out.writeInt(contador);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar el contador
    public static void cargarContador() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("contador.ser"))) {
            contador = in.readInt();
        } catch (IOException e) {
            contador = 0; // Si no se encuentra el archivo, comienza desde 0
        }
    }

    public AtrUsuario iniciarSesion(String user, String contra) {
        for (AtrUsuario u : usuarios) {
            if (u.getUsuario().equals(user) && u.getContra().equals(contra) && u.isEstado()) {
                return u;
            }
        }
        return null;
    }

    @Override
    public void congelarDatos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void descongelarDatos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 

}
