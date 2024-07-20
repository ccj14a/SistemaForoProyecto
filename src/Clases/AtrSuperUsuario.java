package Clases;

import java.io.Serializable; // Importa la interfaz Serializable

public abstract class AtrSuperUsuario implements Serializable {

    //atributos privados
    private String nombres;
    private String usuario;
    private String contra;
    private boolean estado;

    // constructores
    public AtrSuperUsuario(String nombres, String usuario, String contra) {
        this.nombres = nombres;
        this.usuario = usuario;
        this.contra = contra;
    }

    public AtrSuperUsuario() {
    }

    // definiendo métodos abstractos a implementar
    public abstract boolean guardarDatos(String user);

    public abstract boolean login(String user, String contra);

    public abstract void guardarArray(AtrSuperUsuario usuario);

    public abstract void congelarDatos();

    public abstract void descongelarDatos();

    public abstract int mostrarArray();


    // metodos getters and settters para acceder a los atributos
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "" + "nombres=" + nombres + ", usuario=" + usuario + ", contrase\u00f1a=" + contra + ", estado=" + estado + " ";
    }


}
