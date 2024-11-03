/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;
import Utilidades.*;
import java.io.Serializable;

/**
 *
 * @author ALE
 */
public class AtrAdministrador extends AtrSuperUsuario implements metSoloAdministrador,Serializable {

    public AtrAdministrador() {
    }

    @Override
    public boolean guardarDatos(String user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    @Override
    public boolean login(String user, String contra) {
        final String USER_ADMIN = "ADMIN".toLowerCase();
        final String PASSWORD = "ADMIN".toLowerCase();
        return user.equals(USER_ADMIN) && contra.equals(PASSWORD);
    }

    @Override
    public int mostrarArray(){
        return 1;
    }

    @Override
    public boolean DesactivarUsuario(String user, ArrayList<AtrUsuario> usuarios) {
        return Implementacion_Comun.DesactivarUsuario(user, usuarios);
    }

   

    @Override
    public int buscarUsuario(String user, ArrayList<AtrUsuario> usuarios) {
        return Implementacion_Comun.buscarUsuario(user, usuarios);
    }

   

    @Override
    public boolean ActivarUsuario(String user, ArrayList<AtrUsuario> usuarios) {
        return Implementacion_Comun.ActivarUsuario(user, usuarios);
    }

    @Override
    public boolean EliminarUsuario(String user, ArrayList<AtrUsuario> usuarios) {
        return Implementacion_Comun.eliminarUsuario(user, usuarios);
    }

    

    @Override
    public void guardarArray(AtrSuperUsuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 

    

}
