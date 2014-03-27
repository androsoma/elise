/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades.mantenimiento;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author lbertel
 */
@Entity
public class MiembroCuadrilla implements Serializable {
    private static final long serialVersionUID = 1L;

   @Id
   @Column(length = 15, nullable = false)
   private String cedula;
   
   @Column(length = 50, nullable = false)
   private String nombres;

   @Column(length = 50, nullable = false)
   private String apellidos;
   
   @Column(length = 15)
   private String movil;
   
   @Column(length = 15)
   private String telefono;
   
    @ManyToOne
    @JoinColumn(name = "fk_cuadrilla", nullable = true)
    private Cuadrilla cuadrilla;
   
    @ManyToOne
    @JoinColumn(name = "fk_MiembroCuadrilla", nullable = true)
    private RolCuadrilla rolCuadrilla;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public RolCuadrilla getRolCuadrilla() {
        return rolCuadrilla;
    }

    public void setRolCuadrilla(RolCuadrilla rolCuadrilla) {
        this.rolCuadrilla = rolCuadrilla;
    }

    public Cuadrilla getCuadrilla() {
        return cuadrilla;
    }

    public void setCuadrilla(Cuadrilla cuadrilla) {
        this.cuadrilla = cuadrilla;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.cedula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MiembroCuadrilla other = (MiembroCuadrilla) obj;
        return Objects.equals(this.cedula, other.cedula);
    }
    
   
    @Override
    public String toString() {
        return nombres + " " + apellidos;
    }
    
}
