/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades.inventario;

import entidades.inventario.Fabricante;
import entidades.inventario.TipoConexionTransformador;
import entidades.inventario.TipoTransformador;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Cristian Gutiérrez
 */
@Entity
public class Transformador implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "TransformadorSequence", sequenceName = "transformador_seq", allocationSize = 1)
    private Long id;
    
    @Column(nullable = true)
    private boolean exclusivo;
    
    @Column(length = 255, nullable = true)
    private String frecuencia;
    
    @Column(nullable = true)
    private int fase;
    
    @ManyToOne
    @JoinColumn(name = "fk_tipotransformador", nullable = true)
    private TipoTransformador tipoTransformador;
    
    @ManyToOne
    @JoinColumn(name = "fk_tipoconexiontransformador", nullable = true)
    private TipoConexionTransformador tipoConexionTransformador;
    
    @ManyToOne
    @JoinColumn(name = "fk_fabricante", nullable = true)
    private Fabricante fabricante;
    
    @Column(length = 255, nullable = true)
    private String serial;
    
    @Column(length = 255, nullable = true)
    private String voltajeAlta;
    
    @Column(length = 255, nullable = true)
    private String voltajeBaja;
    
    @Column(length = 255, nullable = true)
    private String potencia;
    
    @Column(length = 255, nullable = true)
    private String referencia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isExclusivo() {
        return exclusivo;
    }

    public void setExclusivo(boolean exclusivo) {
        this.exclusivo = exclusivo;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }

    public TipoTransformador getTipoTransformador() {
        return tipoTransformador;
    }

    public void setTipoTransformador(TipoTransformador tipoTransformador) {
        this.tipoTransformador = tipoTransformador;
    }

    public TipoConexionTransformador getTipoConexionTransformador() {
        return tipoConexionTransformador;
    }

    public void setTipoConexionTransformador(TipoConexionTransformador tipoConexionTransformador) {
        this.tipoConexionTransformador = tipoConexionTransformador;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getVoltajeAlta() {
        return voltajeAlta;
    }

    public void setVoltajeAlta(String voltajeAlta) {
        this.voltajeAlta = voltajeAlta;
    }

    public String getVoltajeBaja() {
        return voltajeBaja;
    }

    public void setVoltajeBaja(String voltajeBaja) {
        this.voltajeBaja = voltajeBaja;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transformador)) {
            return false;
        }
        Transformador other = (Transformador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.inventario.Transformador[ id=" + id + " ]";
    }
    
}
