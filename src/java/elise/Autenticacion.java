/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package elise;

/**
 *
 * @author Yeison Osorio
 */
public class Autenticacion {
    private String nombreUsuario;
    private String contrasena;

    /**
     * Creates a new instance of Autenticacion
     */
    public Autenticacion() {
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public String validarUsuario() {
        if (nombreUsuario.compareTo("yosorio") == 0) {
            
            return "pm:inventario";
        } else {            
            return "pm:main";
        }
    }
}
