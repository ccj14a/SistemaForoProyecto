/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import java.util.*;
import Clases.*;

public class Implementacion_Comun {

    // Método para buscar un usuario en la lista por nombre de usuario
    public static int buscarUsuario(String user, ArrayList<AtrUsuario> usuarios) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getUsuario().equals(user)) {
                return i;
            }
        }
        return -1;
    }

    // Método para buscar un especialista en la lista por nombre de usuario
    public static int buscarEspecialista(String user, ArrayList<AtrEspecialistas> especialistas) {
        for (int i = 0; i < especialistas.size(); i++) {
            if (especialistas.get(i).getUsuario().equals(user)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean eliminarUsuario(String user, ArrayList<AtrUsuario> usuarios) {
        int pos = buscarUsuario(user, usuarios);
        if (pos != -1) {
            usuarios.remove(pos); 
            return true;
        }
        return false;

    }

    // Método para eliminar un usuario de la lista por nombre de usuario
    public static boolean DesactivarUsuario(String user, ArrayList<AtrUsuario> usuarios) {
        int pos = buscarUsuario(user, usuarios);
        if (pos != -1) {
            usuarios.get(pos).setEstado(false); // Cambia el estado del usuario a false
            return true;
        }
        return false;
    }

    public static boolean ActivarUsuario(String user, ArrayList<AtrUsuario> usuarios) {
        int pos = buscarUsuario(user, usuarios);
        if (pos != -1) {
            usuarios.get(pos).setEstado(true);
            return true;
        }
        return false;

    }

    public static boolean eliminarEspecialista(String user, ArrayList<AtrEspecialistas> especialistas) {
        int pos = buscarEspecialista(user, especialistas);
        if (pos != -1) {
            especialistas.remove(pos); 
            return true;
        }
        return false;
    }

    // Método para eliminar un especialista de la lista por nombre de usuario
    public static boolean DesactivarEspecialista(String user, ArrayList<AtrEspecialistas> especialistas) {
        int pos = buscarEspecialista(user, especialistas);
        if (pos != -1) {
            especialistas.get(pos).setEstado(false);
            return true;
        }
        return false;
    }

    public static boolean ActivarEspecialista(String user, ArrayList<AtrEspecialistas> especialistas) {
        int pos = buscarEspecialista(user, especialistas);
        if (pos != -1) {
            especialistas.get(pos).setEstado(true);
            return true;
        }
        return false;

    }

}
