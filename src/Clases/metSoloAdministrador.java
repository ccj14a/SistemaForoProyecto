/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Clases;

import java.util.*;

public interface metSoloAdministrador {

    //metodos para los usuarios
    int buscarUsuario(String user, ArrayList<AtrUsuario> usuarios);

    boolean DesactivarUsuario(String user, ArrayList<AtrUsuario> usuarios);

    boolean ActivarUsuario(String user, ArrayList<AtrUsuario> usuarios);

    boolean EliminarUsuario(String user, ArrayList<AtrUsuario> usuarios);

  

}
