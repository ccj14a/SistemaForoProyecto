/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.Serializable; 
/**
 *
 * @author ALE
 */
public class AtrEspecialistas extends AtrSuperUsuario implements Serializable{
    
    private String direccion;
    private String telefono;
    private String dni;
    private String especialidad;
    
    private int idEspecialista;
    private static int contador = 0;
    public ArrayList<AtrEspecialistas> espe = new ArrayList<>();
    
    public AtrEspecialistas(String direccion, String telefono, String dni, String nombres, String usuario, String contraseña,String especialidad) {
        super(nombres, usuario, contraseña);
        this.direccion = direccion;
        this.telefono = telefono;
        this.dni = dni;
        this.especialidad=especialidad;
        this.idEspecialista = ++contador;
        setEstado(false);
    }
    
    public AtrEspecialistas() {
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean guardarDatos(String user) {
        for (AtrEspecialistas u : espe) {
            if (user.equals(u.getUsuario())) {
                return true;
            }
            
        }
        return false;
    }
    
    public void guardarArray(AtrEspecialistas espe) {
        if (guardarDatos(espe.getUsuario())) {
            JOptionPane.showMessageDialog(null, "Ese usuario ya está en uso, coloque otro", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            
            System.out.println();
        } else {
            this.espe.add(espe);
            JOptionPane.showMessageDialog(null, "Su solicitud será revisada\nUna vez aprobada podrá ingresar a la app", "Registro Completo", JOptionPane.INFORMATION_MESSAGE);
            
        }
    }
    
    ;

  
    
    @Override
    public boolean login(String user, String contra) {
        for (AtrEspecialistas u : espe) {
            if (u.getUsuario().equals(user) && u.getContra().equals(contra) && u.isEstado()) {
                return true;
            }
        }
        return false;
    }
      public AtrEspecialistas iniciarSesion(String user, String contraseña) {
        for (AtrEspecialistas u : espe) {
            if (u.getUsuario().equals(user) && u.getContra().equals(contraseña) && u.isEstado()) {
                return u;
            }
        }
        return null;
    }
    
    @Override
    public int mostrarArray() {
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Especialistas Registrados:\n");
        for (AtrEspecialistas u : espe) {
            mensaje.append(u).append("\n");
        }
        String[] opciones = {"Desactivar Especialista", "Reactivar Especialista", "Eliminar Especialista", "Cancelar"};
        int seleccion = JOptionPane.showOptionDialog(null, mensaje.toString(), "Especialistas Registrados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
        
        return seleccion;
    }

    @Override
    public String toString() {
        return " idEspecialista=" + idEspecialista + ", "+super.toString()+"," +
                "direccion=" + direccion +
                ", telefono=" + telefono +
                ", dni=" + dni +
                ", especialidad=" + especialidad +""
                ;
    }

    @Override
    public void guardarArray(AtrSuperUsuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
