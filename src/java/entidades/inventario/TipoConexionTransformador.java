/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades.inventario;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * <p>Indica el tipo de tipo de conexion que posee el transformador</p>
 * 
 * @author Cristian Gutierrez
 */
@Entity
public class TipoConexionTransformador implements Serializable {
    private static final long serialVersionUID = 1L;
    @SequenceGenerator(name="TipoConexionTransformadorSequence", sequenceName = "tipo_conexion_transformador_seq", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="TipoConexionTransformadorSequence")
    private Long id;
    
    @Column(length = 100, nullable = false)
    private String descripcion;
    @Column (nullable = false)
    private boolean activo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoConexionTransformador)) {
            return false;
        }
        TipoConexionTransformador other = (TipoConexionTransformador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descripcion;
    }
    
}
