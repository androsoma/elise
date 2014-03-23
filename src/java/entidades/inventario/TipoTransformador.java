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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author desarrollo8
 */
@Entity
@NamedQueries({
    @NamedQuery(name = TipoTransformador.BUSCAR_POR_NOMBRE , query = "SELECT t FROM TipoTransformador t WHERE t.descripcion = :nombre")
})
public class TipoTransformador implements Serializable {
    
    
    public static final String BUSCAR_POR_NOMBRE = "TipoTransformador.buscarPorNombre";
    
    private static final long serialVersionUID = 1L;
    @SequenceGenerator (name = "TipoTransformadorSequence", sequenceName = "tipo_transformador_seq", allocationSize =1 )
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TipoTransformadorSequence")
    private Long id;
    
    @Column (length = 100, nullable = false)
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
        if (!(object instanceof TipoTransformador)) {
            return false;
        }
        TipoTransformador other = (TipoTransformador) object;
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
